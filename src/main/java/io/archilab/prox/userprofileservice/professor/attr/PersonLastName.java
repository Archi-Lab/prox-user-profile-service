package io.archilab.prox.userprofileservice.professor.attr;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonLastName {

    private static final int MAX_LENGTH = 127;

    private String lastName;

    public PersonLastName(String lastName) {
        if(!isValid(lastName)) {
            throw new IllegalArgumentException(
                    String.format("LastName %s exceeded maximum number of %d allowed characters or is NULL", lastName,
                            PersonLastName.MAX_LENGTH));
        }
        this.lastName = lastName.trim();
    }

    public static boolean isValid(String lastName) {
        return lastName != null && lastName.length() <= PersonLastName.MAX_LENGTH;
    }
}
