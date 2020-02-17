package io.archilab.prox.userprofileservice.config;

import io.archilab.prox.userprofileservice.module.StudyCourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportConfig {

  @Bean
  CommandLineRunner runFeign(StudyCourseService studyCourseService) {
    return args -> studyCourseService.importStudyCourses();
  }

}
