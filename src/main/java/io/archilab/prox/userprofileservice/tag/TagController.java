package io.archilab.prox.userprofileservice.tag;
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
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagRepository repository;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tag> getAllTags() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Tag> getTagById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/tag/{tag}", method = RequestMethod.GET)
    public List<Tag> getProfByFirstName(@PathVariable("tag") String name) {
        return repository.findByBeschreibung(name);
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Tag createTag(@Validated @RequestBody Tag tag) {
        tag.setId(ObjectId.get().toString());
        repository.save(tag);
        return tag;
    }


}
