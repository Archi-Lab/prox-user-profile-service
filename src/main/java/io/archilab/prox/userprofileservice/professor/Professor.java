package io.archilab.prox.userprofileservice.professor;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
    @JsonUnwrapped
    private UUID keycloakId;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private PersonName name;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private ProfessorTitle title;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private ProfessorAdresse adresse;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private ProfessorStrasse strasse;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private ProfessorPlz plz;

    @Setter
    @JsonUnwrapped
    private ProfessorRaum raum;

    @Setter
    @JsonUnwrapped
    private PersonPhoneNumber phoneNumber;

    @Setter
    @JsonUnwrapped
    private PersonMail mail;

    @Setter
    @JsonUnwrapped
    private ProfessorSprechzeiten sprechzeiten;

    @Setter
    @JsonUnwrapped
    private PersonBildSrc bildSrc;

    @Setter
    @JsonUnwrapped
    private PersonAboutMe aboutMe;


    public Professor(@NotNull UUID keycloakId, @NotNull PersonName name, ProfessorTitle title, ProfessorAdresse adresse, ProfessorStrasse strasse,
                     ProfessorPlz plz, ProfessorRaum raum, PersonPhoneNumber phoneNumber, PersonMail mail, ProfessorSprechzeiten sprechzeiten,
                     PersonBildSrc bildSrc, PersonAboutMe aboutMe) {

        this.keycloakId = keycloakId;
        this.name = name;
        this.title = title;
        this.adresse = adresse;
        this.strasse = strasse;
        this.plz = plz;
        this.raum = raum;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.sprechzeiten = sprechzeiten;
        this.bildSrc = bildSrc;
        this.aboutMe = aboutMe;
    }

    public Professor(@NotNull UUID keycloakId, @NotNull PersonName name) {

        this.keycloakId = keycloakId;
        this.name = name;
    }
}
