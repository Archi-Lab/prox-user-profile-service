package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.professor.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

}
