package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.core.AbstractEntity;
import io.archilab.prox.userprofileservice.professor.attr.PersonAboutMe;
import io.archilab.prox.userprofileservice.professor.attr.PersonMail;
import io.archilab.prox.userprofileservice.professor.attr.PersonName;
import io.archilab.prox.userprofileservice.professor.attr.PersonPhoneNumber;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student extends AbstractEntity
{
    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private UUID keycloakId;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private PersonName name;

    @Setter(AccessLevel.PUBLIC)
    private PersonPhoneNumber phoneNumber;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private PersonMail mail;

    @Setter(AccessLevel.PUBLIC)
    private String tags;

    @Setter(AccessLevel.PUBLIC)
    private PersonAboutMe aboutMe;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private String studiengang;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private String schwerpunkt;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private String semester;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private String status;

    @Setter(AccessLevel.PUBLIC)
    private String qualifikation;

    @Setter(AccessLevel.PUBLIC)
    private String doneModules;

    @Setter(AccessLevel.PUBLIC)
    private String doneJobs;

    public Student(@NotNull UUID keycloakId, @NotNull PersonName name, PersonPhoneNumber phoneNumber, PersonMail mail,
                   String tags, PersonAboutMe aboutMe, String studiengang, String schwerpunkt, String semester, String status,
                   String qualifikation, String doneModules, String doneJobs){

        this.keycloakId = keycloakId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.tags = tags;
        this.aboutMe = aboutMe;
        this.studiengang = studiengang;
        this.schwerpunkt = schwerpunkt;
        this.semester = semester;
        this.qualifikation = qualifikation;
        this.doneModules = doneModules;
        this.doneJobs = doneJobs;
    }
}
