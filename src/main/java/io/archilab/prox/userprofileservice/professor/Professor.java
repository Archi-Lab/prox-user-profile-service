package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.core.AbstractEntity;
import io.archilab.prox.userprofileservice.professor.attr.ProfessorDescription;
import io.archilab.prox.userprofileservice.professor.attr.ProfessorFirstName;
import io.archilab.prox.userprofileservice.professor.attr.ProfessorLastName;
import io.archilab.prox.userprofileservice.professor.attr.ProfessorTitle;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends AbstractEntity {

    @NotNull
    @Setter
    private ProfessorFirstName firstName;

    @NotNull
    @Setter
    private ProfessorLastName lastName;

    @Setter
    private ProfessorTitle title;

    @Setter
    private ProfessorDescription description;

    @Setter
    private String raum;

    @Setter
    private long telefonnummer;

    @Setter
    private String email;

    @Setter
    private String sprechzeiten;

    @Setter
    private String bildSrc;

    @NotNull
    @Setter
    private String fachgebiet;



}
