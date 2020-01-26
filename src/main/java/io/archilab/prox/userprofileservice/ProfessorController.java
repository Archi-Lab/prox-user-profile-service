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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class ProfessorController {

    private Logger LOG = Logger.getGlobal();

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping(value = "/userprofile/professors")
    public Page findProfessors(Pageable pageable)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findProfessors");
        return professorRepository.findAll(pageable);
    }

    @GetMapping(value = "/userprofile/professors/findByName")
    public List<Professor> findProfessorsByName(@Valid @RequestBody PersonName name)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findProfessorsByName");
        return professorRepository.findByName(name);
    }

    @PostMapping(value = "/userprofile/professors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Professor createProfessor(@Valid @RequestBody Professor professor)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: createProfessor");
        return professorRepository.save(professor);
    }

    @PutMapping(value = "/userprofile/professors/{professorId}")
    public Professor updateProfessor(@PathVariable UUID professorId,
                                     @Valid @RequestBody Professor professorRequest)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: updateProfessor");
        return professorRepository.findByKeycloakId(professorId)
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
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen:  deleteProfessor");
        return professorRepository.findById(professorId)
                .map(professor -> {
                    professorRepository.delete(professor);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Professor with id " + professorId + " not found"));
    }

    @GetMapping(value = "/userprofile/professors/{professorId}")
    public Optional<Professor> findProfessorById(@PathVariable UUID professorId)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findProfessorById");
        return professorRepository.findByKeycloakId(professorId);
    }

    @GetMapping(value = "/userprofile/professors/get/{professorKeycloakId}")
    public Optional<Professor> findProfessorByKeycloakId(@PathVariable UUID professorKeycloakId)
    {
        Date date = new Date();
        LOG.info( date.toString() + " Methode aufgerufen: findProfessorByKeycloakId");
        return professorRepository.findByKeycloakId(professorKeycloakId);
    }

}