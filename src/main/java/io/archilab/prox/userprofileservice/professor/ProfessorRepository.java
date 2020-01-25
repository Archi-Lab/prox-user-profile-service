package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.professor.attr.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findById(UUID id);
    List<Professor> findByName(PersonName firstName);
    Optional<Professor> findByKeycloakId(UUID keycloakId);

}
