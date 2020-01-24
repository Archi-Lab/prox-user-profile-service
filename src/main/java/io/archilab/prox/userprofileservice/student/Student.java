package io.archilab.prox.userprofileservice.student;

import io.archilab.prox.userprofileservice.core.AbstractEntity;
import io.archilab.prox.userprofileservice.professor.attr.PersonFirstName;
import io.archilab.prox.userprofileservice.professor.attr.PersonLastName;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student extends AbstractEntity
{
    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private PersonFirstName firstName;

    @NotNull
    @Setter(AccessLevel.PUBLIC)
    private PersonLastName lastName;

    public Student(@NotNull PersonFirstName firstName, @NotNull PersonLastName lastName){

        this.firstName = firstName;
        this.lastName = lastName;
    }
}
