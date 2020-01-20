package io.archilab.prox.userprofileservice;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.professor.ProfessorRepository;
import io.archilab.prox.userprofileservice.professor.attr.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserProfileService {

    public static void main(String[] args) {
        SpringApplication.run(UserProfileService.class, args);

    }
}
