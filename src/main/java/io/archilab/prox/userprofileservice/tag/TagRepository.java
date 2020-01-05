package io.archilab.prox.userprofileservice.tag;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {

    List<Tag> findByBeschreibung (String name);
}
