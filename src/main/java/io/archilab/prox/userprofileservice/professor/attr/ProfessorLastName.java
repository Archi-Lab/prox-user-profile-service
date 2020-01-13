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
public class ProfessorLastName {

    private static final int MAX_LENGTH = 127;

    private String lastName;

    public ProfessorLastName(String lastName) {
        if(!isValid(lastName)) {
            throw new IllegalArgumentException(
                    String.format("LastName %s exceeded maximum number of %d allowed characters", lastName,
                            ProfessorLastName.MAX_LENGTH));
        }
        this.lastName = lastName.trim();
    }

    public static boolean isValid(String lastName) {
        return lastName != null && lastName.length() <= ProfessorLastName.MAX_LENGTH;
    }
}
