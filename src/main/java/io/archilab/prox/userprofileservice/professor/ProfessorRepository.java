package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.professor.attr.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {

    Optional<Professor> findById(@Param(value = "id") UUID id);
    List<Professor> findByNameNameContains(@Param(value = "name")PersonName name);
    Set<Professor> findByKeycloakId(@Param(value = "keycloakId") UUID keycloakId);

}
