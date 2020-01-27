package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    Optional<Student> findById(@Param(value = "id")UUID id);
    Optional<Student> findByKeycloakId(@Param(value = "keycloakId") UUID keycloakId);
}
