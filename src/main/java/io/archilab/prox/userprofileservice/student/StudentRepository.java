package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    Optional<Student> findById(UUID uuid);
    Optional<Student> findByKeycloakId(UUID keycloakId);
}
