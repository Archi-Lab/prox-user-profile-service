package io.archilab.prox.userprofileservice.professor;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProfessorRepository extends MongoRepository<Professor, String>
{
    List<Professor> findByFirstName(String firstName);
    List<Professor> findByLastName(String lastName);
    List<Professor> findByDescription(ProfessorDescription profileDescription);
}