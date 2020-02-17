package io.archilab.prox.userprofileservice.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class StudyCourseService {

  private final Logger logger = LoggerFactory.getLogger(StudyCourseService.class);

  private final StudyCourseClient studyCourseClient;
  private final ModuleRepository moduleRepository;
  private final StudyCourseRepository studyCourseRepository;


  public StudyCourseService(StudyCourseClient studyCourseClient, ModuleRepository moduleRepository,
                            StudyCourseRepository studyCourseRepository) {
    this.studyCourseClient = studyCourseClient;
    this.moduleRepository = moduleRepository;

    this.studyCourseRepository = studyCourseRepository;
  }

  public void importStudyCourses() {
    this.logger.info("Start importing Study Courses");

    List<StudyCourse> studyCourses = this.studyCourseClient.getStudyCourses();
    for (StudyCourse studyCourse : studyCourses) {

      List<Module> newModules = new ArrayList<>();
      Set<Module> retrievedModules = studyCourse.getModules();
      for (Module module : retrievedModules) {
        Optional<Module> existingModuleOptional =
            this.moduleRepository.findById(module.getId());

        if (existingModuleOptional.isPresent()) {
          this.logger.info("Module with ID " + module.getId() + " already exists.");
          Module existingModule = existingModuleOptional.get();
          existingModule.setName(module.getName());
          newModules.add(existingModule);
          this.moduleRepository.save(existingModule);
        } else {
          this.logger
              .info("Module with ID " + module.getId() + " does not exist yet.");
          newModules.add(module);
          this.moduleRepository.save(module);
        }
      }

      Optional<StudyCourse> existingStudyCourseOptional = this.studyCourseRepository
          .findById(studyCourse.getId());

      if (existingStudyCourseOptional.isPresent()) {
        this.logger.info(
            "StudyCourse with ID " + studyCourse.getId() + " already exists.");
        StudyCourse existingStudyCourse = existingStudyCourseOptional.get();
        existingStudyCourse.setName(studyCourse.getName());
        existingStudyCourse.setAcademicDegree(studyCourse.getAcademicDegree());
        this.studyCourseRepository.save(existingStudyCourse);

      } else {
        this.logger.info("StudyCourse with ID " + studyCourse.getId()
            + " does not exist yet.");
        this.studyCourseRepository.save(studyCourse);
      }
    }
  }
}
