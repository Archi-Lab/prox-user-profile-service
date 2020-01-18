package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.professor.attr.PersonLastName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professor")
    public Page findProfessors(Pageable pageable)
    {
        return professorRepository.findAll(pageable);
    }

    @GetMapping("/professor/findByLastName")
    public List<Professor> findProfessorsByLastName(@Valid @RequestBody PersonLastName lastName)
    {
        return professorRepository.findByLastName(lastName);
    }

    @PostMapping(value = "/professor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Professor createProfessor(@Valid @RequestBody Professor professor)
    {
        return professorRepository.save(professor);
    }

    @PutMapping("/professor/{professorId}")
    public Professor updateProfessor(@PathVariable UUID professorId,
                                     @Valid @RequestBody Professor professorRequest)
    {
        return professorRepository.findById(professorId)
                .map(professor -> {
                    professor.setFirstName(professorRequest.getFirstName());
                    professor.setLastName((professorRequest.getLastName()));
                    professor.setTitle((professorRequest.getTitle()));
                    professor.setDescription(professorRequest.getDescription());
                    professor.setRaum((professorRequest.getRaum()));
                    professor.setTelefonnummer(professorRequest.getTelefonnummer());
                    professor.setEmail(professorRequest.getEmail());
                    professor.setSprechzeiten(professorRequest.getSprechzeiten());
                    professor.setBildSrc(professorRequest.getBildSrc());
                    professor.setFachgebiet(professorRequest.getFachgebiet());
                    return professorRepository.save(professor);
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + professorId + "not found"));
    }

    @DeleteMapping("professor/{professorId}")
    public ResponseEntity<?> deleteProfessor(@PathVariable UUID professorId)
    {
        return professorRepository.findById(professorId)
                .map(professor -> {
                    professorRepository.delete(professor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + professorId + " not found"));
    }
}
