package io.archilab.prox.userprofileservice.professor;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profs")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Professor> getAllProfs() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Professor> getProfById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/first/{firstname}", method = RequestMethod.GET)
    public List<Professor> getProfByFirstName(@PathVariable("firstname") String name) {
        return repository.findByFirstName(name);
    }

    @RequestMapping(value = "/last/{lastname}", method = RequestMethod.GET)
    public List<Professor> getProfByLastName(@PathVariable("lastname") String name) {
        return repository.findByLastName(name);
    }

    @RequestMapping(value = "/desc/{description}", method = RequestMethod.GET)
    public List<Professor> getProfByDescription(@PathVariable("description") ProfessorDescription text) {
        return repository.findByDescription(text);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Professor createProfessor(@Validated @RequestBody Professor prof) {
        prof.setId(ObjectId.get().toString());
        repository.save(prof);
        return prof;
    }

   // @RequestMapping(value = "/{lastname}", method = RequestMethod.PUT)
  //  public void modifyMailByLastname(@PathVariable("lastname") String email, @Validated @RequestBody Professor prof) {
  //      prof.setEmail(email);
  //      repository.save(prof);
   // }
}
