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
    private PersonName name;

    @Setter(AccessLevel.PUBLIC)
    private ProfessorAdresse adresse;

    @Setter(AccessLevel.PUBLIC)
    private ProfessorStrasse strasse;

    @Setter(AccessLevel.PUBLIC)
    private ProfessorPlz plz;

    @Setter
    private ProfessorRaum raum;

    @Setter
    private PersonPhoneNumber phoneNumber;

    @Setter
    private PersonMail mail;

    @Setter(AccessLevel.PUBLIC)
    private String tags;

    @Setter
    private ProfessorSprechzeiten sprechzeiten;

    @Setter
    private ProfessorBildSrc bildSrc;

    @Setter
    private PersonAboutMe aboutMe;


    public Professor(@NotNull UUID keycloakId, @NotNull PersonName name, ProfessorAdresse adresse, ProfessorStrasse strasse,
                     ProfessorPlz plz, ProfessorRaum raum, PersonPhoneNumber phoneNumber, PersonMail mail, String tags, ProfessorSprechzeiten sprechzeiten,
                     ProfessorBildSrc bildSrc, PersonAboutMe aboutMe) {

        this.keycloakId = keycloakId;
        this.name = name;
        this.adresse = adresse;
        this.strasse = strasse;
        this.plz = plz;
        this.raum = raum;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.tags = tags;
        this.sprechzeiten = sprechzeiten;
        this.bildSrc = bildSrc;
        this.aboutMe = aboutMe;
    }
}
