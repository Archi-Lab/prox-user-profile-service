package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.core.AbstractEntity;
import io.archilab.prox.userprofileservice.professor.attr.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Professor extends AbstractEntity {

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    @Getter
    private UUID keycloakId;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private PersonFirstName firstName;

    @NotNull
    @Setter
    private PersonLastName lastName;

    @Setter
    private ProfessorTitle title;

    @Setter
    private ProfessorDescription description;

    @Setter
    private ProfessorRaum raum;

    @Setter
    private ProfessorTelefonnummer telefonnummer;

    @Setter
    private ProfessorEmail email;

    @Setter
    private ProfessorSprechzeiten sprechzeiten;

    @Setter
    private ProfessorBildSrc bildSrc;

    @NotNull
    @Setter
    private ProfessorFachgebiet fachgebiet;

    public Professor(@NotNull UUID keycloakId, @NotNull PersonFirstName firstName, @NotNull PersonLastName lastName, ProfessorTitle title, ProfessorDescription description,
                     ProfessorRaum raum, ProfessorTelefonnummer telefonnummer, ProfessorEmail email, ProfessorSprechzeiten sprechzeiten, ProfessorBildSrc bildSrc,
                     @NotNull ProfessorFachgebiet fachgebiet) {

        this.keycloakId = keycloakId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.description = description;
        this.raum = raum;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.sprechzeiten = sprechzeiten;
        this.bildSrc = bildSrc;
        this.fachgebiet = fachgebiet;
    }
}
