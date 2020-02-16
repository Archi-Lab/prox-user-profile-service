package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.professor.attr.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitRunner implements CommandLineRunner {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {

        UUID uuid = UUID.randomUUID();

        Professor karsch = new Professor(uuid,new PersonName("Stefan Karsch"), new ProfessorTitle("Prof."),
                new ProfessorAdresse("Steinmüller"), new ProfessorStrasse("SteinmüllerStraße"), new ProfessorPlz("12345"),
                new ProfessorRaum("KTDS Labor"), new PersonPhoneNumber("12345679"), new PersonMail("Stefan.Karsch@th-koeln.de"),
                new String[] {"KTN"}, new ProfessorSprechzeiten("Montags 10:00-10:30"),new ProfessorBildSrc("https://google.de"), new PersonAboutMe("Hallo."));

        Professor koehler = new Professor(uuid,new PersonName("Lutz Koehler"), new ProfessorTitle("Prof."),
                new ProfessorAdresse("Steinmüller"), new ProfessorStrasse("SteinmüllerStraße"), new ProfessorPlz("12345"),
                new ProfessorRaum("R.0100"), new PersonPhoneNumber("12345679"), new PersonMail("Lutz.Koehler@th-koeln.de"),
                new String[] {"BS"}, new ProfessorSprechzeiten("Montags 10:00-10:30"),new ProfessorBildSrc("https://google.de"), new PersonAboutMe("Hallo, mein Name ist Lutz Köhler."));

        Professor bente = new Professor(uuid,new PersonName("Stefan Bente"), new ProfessorTitle("Prof."),
                new ProfessorAdresse("Steinmüller"), new ProfessorStrasse("SteinmüllerStraße"), new ProfessorPlz("12345"),
                new ProfessorRaum("R.1234"), new PersonPhoneNumber("12345679"), new PersonMail("Stefan.Bente@th-koeln.de"),
                new String[] {"ST1","ST2"}, new ProfessorSprechzeiten("Montags 10:00-10:30"),new ProfessorBildSrc("https://google.de"), new PersonAboutMe("Hallo."));

        professorRepository.save(karsch);
        professorRepository.save(koehler);
        professorRepository.save(bente);

    }
}
