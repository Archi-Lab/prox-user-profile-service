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
import java.util.Optional;
import java.util.UUID;

@RestController
public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/userprofile/students")
    public Page findStudents(Pageable pageable)
    {
        return studentRepository.findAll(pageable);
    }

    @PostMapping(value = "/userprofiles/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student createProfessor(@Valid @RequestBody Student student)
    {
        return studentRepository.save(student);
    }

    @GetMapping(value = "/userprofile/students/{studentId}")
    public Optional<Student> findStudentById(@PathVariable UUID studentId)
    {
        return studentRepository.findById(studentId);
    }

    @GetMapping(value =  "/userprofile/students/get/{keycloakId}")
    public Optional<Student> findStudentByKeycloakId(@PathVariable UUID keycloakId)
    {
        return studentRepository.findByKeycloakId(keycloakId);
    }

    @PutMapping(value = "/userprofile/students/{studentId}")
    public Student updateProfessor(@PathVariable UUID studentId,
                                     @Valid @RequestBody Student studentRequest)
    {
        return studentRepository.findById(studentId)
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
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + studentId + "not found"));
    }

}
