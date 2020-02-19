package io.archilab.prox.userprofileservice.student;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.archilab.prox.userprofileservice.core.AbstractEntity;
import io.archilab.prox.userprofileservice.module.Module;
import io.archilab.prox.userprofileservice.professor.attr.*;
import io.archilab.prox.userprofileservice.student.attr.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;
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
    @JsonUnwrapped
    private PersonName name;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private PersonPhoneNumber phoneNumber;

    @JsonUnwrapped
    @Setter(AccessLevel.PUBLIC)
    private PersonMail mail;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private PersonAboutMe aboutMe;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private StudentStudiengang studiengang;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private StudentSchwerpunkt schwerpunkt;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private StudentStatus status;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private StudentQualifikation qualifikation;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    @ElementCollection
    private List<Module> modules;

    @Setter(AccessLevel.PUBLIC)
    @JsonUnwrapped
    private StudentDoneJobs doneJobs;

    @Setter
    @JsonUnwrapped
    private ProfessorBildSrc bildSrc;

    public Student(@NotNull UUID keycloakId, @NotNull PersonName name, PersonPhoneNumber phoneNumber, PersonMail mail,
                   PersonAboutMe aboutMe, StudentStudiengang studiengang, StudentSchwerpunkt schwerpunkt, StudentStatus status,
                   StudentQualifikation qualifikation, StudentDoneJobs doneJobs, ProfessorBildSrc bildSrc){

        this.keycloakId = keycloakId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.aboutMe = aboutMe;
        this.studiengang = studiengang;
        this.schwerpunkt = schwerpunkt;
        this.status = status;
        this.qualifikation = qualifikation;
        this.doneJobs = doneJobs;
        this.bildSrc=bildSrc;
    }

    public Student(@NotNull UUID keycloakId, @NotNull PersonName name) {

        this.keycloakId = keycloakId;
        this.name = name;
    }

    public void addModule(Module module) {
        this.modules.add(module);
    }
}
