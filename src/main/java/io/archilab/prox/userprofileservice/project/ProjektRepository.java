package io.archilab.prox.userprofileservice.project;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjektRepository extends MongoRepository<Projekt, String> {

    List<Projekt> findByName (String name);
}
