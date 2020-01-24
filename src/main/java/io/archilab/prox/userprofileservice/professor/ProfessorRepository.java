package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.professor.attr.PersonFirstName;
import io.archilab.prox.userprofileservice.professor.attr.PersonLastName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findById(UUID id);
    List<Professor> findByFirstName(PersonFirstName firstName);
    List<Professor> findByLastName(PersonLastName lastName);
    Optional<Professor> findByKeycloakId(UUID keycloakId);

}
