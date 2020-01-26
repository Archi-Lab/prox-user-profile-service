package io.archilab.prox.userprofileservice;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.student.Student;
import io.archilab.prox.userprofileservice.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;

    private Logger LOG = Logger.getGlobal();

    @GetMapping(value = "/userprofile/students")
    public Page findStudents(Pageable pageable)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findStudents");
        return studentRepository.findAll(pageable);
    }

    @PostMapping(value = "/userprofile/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@Valid @RequestBody Student student)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: createStudent");
        return studentRepository.save(student);
    }

    @GetMapping(value = "/userprofile/students/{studentId}")
    public Optional<Student> findStudentById(@PathVariable UUID studentId)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findStudentById");
        return studentRepository.findByKeycloakId(studentId);
    }

    @GetMapping(value =  "/userprofile/students/get/{keycloakId}")
    public Optional<Student> findStudentByKeycloakId(@PathVariable UUID keycloakId)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findStudentByKeycloakId");
        return studentRepository.findByKeycloakId(keycloakId);
    }

    @PutMapping(value = "/userprofile/students/{studentId}")
    public Student updateStudent(@PathVariable UUID studentId,
                                     @Valid @RequestBody Student studentRequest)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: updateStudent");
        return studentRepository.findByKeycloakId(studentId)
                .map(student -> {
                    student.setName(studentRequest.getName());
                    student.setPhoneNumber(studentRequest.getPhoneNumber());
                    student.setMail(studentRequest.getMail());
                    student.setTags(studentRequest.getTags());
                    student.setAboutMe(studentRequest.getAboutMe());
                    student.setStudiengang(studentRequest.getStudiengang());
                    student.setSchwerpunkt(studentRequest.getSchwerpunkt());
                    student.setSemester(studentRequest.getSemester());
                    student.setStatus(studentRequest.getStatus());
                    student.setQualifikation(studentRequest.getQualifikation());
                    student.setDoneModules(studentRequest.getDoneModules());
                    student.setDoneJobs(studentRequest.getDoneJobs());
                    return studentRepository.save(student);
                }).orElseThrow(() -> new ResourceNotFoundException("Student with id " + studentId + "not found"));
    }

}
