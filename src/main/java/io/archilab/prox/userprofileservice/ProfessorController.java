package io.archilab.prox.userprofileservice;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.professor.ProfessorRepository;
import io.archilab.prox.userprofileservice.professor.attr.PersonName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping(value = "/userprofile/professors")
    public Page findProfessors(Pageable pageable)
    {
        return professorRepository.findAll(pageable);
    }

    @GetMapping(value = "/userprofile/professors/findByName")
    public List<Professor> findProfessorsByLastName(@Valid @RequestBody PersonName name)
    {
        return professorRepository.findByName(name);
    }

    @PostMapping(value = "/userprofile/professors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Professor createProfessor(@Valid @RequestBody Professor professor)
    {
        return professorRepository.save(professor);
    }

    @PutMapping(value = "/userprofile/professors/{professorId}")
    public Professor updateProfessor(@PathVariable UUID professorId,
                                     @Valid @RequestBody Professor professorRequest)
    {
        return professorRepository.findById(professorId)
                .map(professor -> {
                    professor.setName(professorRequest.getName());
                    professor.setAdresse((professorRequest.getAdresse()));
                    professor.setStrasse(professorRequest.getStrasse());
                    professor.setPlz((professorRequest.getPlz()));
                    professor.setRaum(professorRequest.getRaum());
                    professor.setPhoneNumber(professorRequest.getPhoneNumber());
                    professor.setMail(professorRequest.getMail());
                    professor.setTags(professorRequest.getTags());
                    professor.setSprechzeiten(professorRequest.getSprechzeiten());
                    professor.setBildSrc(professorRequest.getBildSrc());
                    professor.setAboutMe(professorRequest.getAboutMe());
                    return professorRepository.save(professor);
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + professorId + "not found"));
    }

    @DeleteMapping(value = "/userprofile/professors/{professorId}")
    public ResponseEntity<?> deleteProfessor(@PathVariable UUID professorId)
    {
        return professorRepository.findById(professorId)
                .map(professor -> {
                    professorRepository.delete(professor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + professorId + " not found"));
    }

    @GetMapping(value = "/userprofile/professors/{professorId}")
    public Optional<Professor> findProfessorById(@PathVariable UUID professorId)
    {
        return professorRepository.findById(professorId);
    }

    @GetMapping(value = "/userprofile/professors/get/{professorKeycloakId}")
    public Optional<Professor> findProfessorByKeycloakId(@PathVariable UUID professorKeycloakId)
    {
        return professorRepository.findByKeycloakId(professorKeycloakId);
    }

}