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
public class ProfessorFirstName {

    private static final int MAX_LENGTH = 127;

    private String firstName;

    public ProfessorFirstName(String firstName) {
        if(!isValid(firstName)) {
            throw new IllegalArgumentException(
                    String.format("FirstName %s exceeded maximum number of %d allowed characters", firstName,
                            ProfessorFirstName.MAX_LENGTH));
        }
        this.firstName = firstName.trim();
    }

    public static boolean isValid(String firstName) {
        return firstName != null && firstName.length() <= ProfessorFirstName.MAX_LENGTH;
    }
}
