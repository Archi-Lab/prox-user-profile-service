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
public class ProfessorRaum {

    private String raum;

    private static int MAX_LENGTH = 16;

    public ProfessorRaum() {}

    public ProfessorRaum(String raum)
    {
        if(!isValid(raum)) {
            throw new IllegalArgumentException(
                    String.format("LastName %s exceeded maximum number of %d allowed characters", raum,
                            MAX_LENGTH));
        }
        this.raum = raum.trim();
    }

    public static boolean isValid(String raum) {
        return raum != null && raum.length() <= MAX_LENGTH;
    }
}


