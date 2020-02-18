package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.professor.attr.PersonName;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID>
{
    Optional<Student> findById(@Param(value = "id")UUID id);
    Set<Student> findByKeycloakId(@Param(value = "keycloakId") UUID keycloakId);
    List<Student> findByNameNameContains(@Param(value = "name") PersonName name);
    List<Student> findByStatus(@Param(value = "status") String status);
}
