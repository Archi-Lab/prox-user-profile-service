package io.archilab.prox.userprofileservice.project;
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
@RequestMapping("/projects")
public class ProjektController {
    @Autowired
    private ProjektRepository repository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Projekt> getAllProjects() {
        return repository.findAll();
    }
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Projekt> getProjektByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Projekt> getProjectById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Projekt createProjekt(@Validated @RequestBody Projekt project) {
        project.setId(ObjectId.get().toString());
        repository.save(project);
        return project;
    }

}
