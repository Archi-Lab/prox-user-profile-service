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

    @Bean
    public CommandLineRunner test(ProfessorRepository repository) {

        repository.deleteAll();

        return (args) -> {
            Professor p = new Professor(new PersonFirstName("Max  "), new PersonLastName("     Mustermann"), ProfessorTitle.DOKTOR, new ProfessorDescription("Hallo, mein Name ist Dr. Max Mustermann und ich gebe Vorlesung mit Herz"),
                    new ProfessorRaum("R.0100"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Max.Mustermann@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 14:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.INFORMATIK);

            repository.save(p);

            Professor p2 = new Professor(new PersonFirstName("Hans  "), new PersonLastName("     Dozent"), ProfessorTitle.DOKTOR, new ProfessorDescription(""),
                    new ProfessorRaum("R.0100"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Hans.Dorenz@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 14:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.INFORMATIK);

            repository.save(p2);

            Professor p3 = new Professor(new PersonFirstName("Herr  "), new PersonLastName("     Lehrer"), ProfessorTitle.PROFESSOR, new ProfessorDescription("Esse Fritte mit Herz"),
                    new ProfessorRaum("R.0100"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Herr.Lehrer@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 14:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.ELEKTROTECHNIK);

            repository.save(p3);

            Professor p4 = new Professor(new PersonFirstName("Lars  "), new PersonLastName("     Oel"), ProfessorTitle.PROFESSOR, new ProfessorDescription("Deutschlands bester Callshop client"),
                    new ProfessorRaum("R.5100"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Lars.Oel@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 14:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.MASCHINENBAU);

            repository.save(p4);

            Professor p5 = new Professor(new PersonFirstName("Gustav  "), new PersonLastName("     Oel"), ProfessorTitle.PROFESSOR, new ProfessorDescription("Dreibeiniger Kanalreiniger und arbeite hart"),
                    new ProfessorRaum("R.0100"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Herr.Lehrer@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 14:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.ELEKTROTECHNIK);

            repository.save(p5);

            Professor p6 = new Professor(new PersonFirstName("We "), new PersonLastName("     Lan"), ProfessorTitle.DOKTOR, new ProfessorDescription("Hallo in meinem Raum gibt es leider keinen eduroam empfang."),
                    new ProfessorRaum("R.1244"), new ProfessorTelefonnummer(22620123456L), new ProfessorEmail("Herr.Lehrer@bla.de"), new ProfessorSprechzeiten("Montag - Freitag 10:00 - 16:00"),
                    new ProfessorBildSrc("https://bildSrc.jpg"), ProfessorFachgebiet.INFORMATIK);

            repository.save(p6);

            PersonLastName  p7 = new PersonLastName("Oel");
        };
    }
}
