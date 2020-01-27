package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.professor.Professor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID>
{
    Optional<Student> findById(@Param(value = "id")UUID id);
    Optional<Student> findByKeycloakId(@Param(value = "keycloakId") UUID keycloakId);
}
