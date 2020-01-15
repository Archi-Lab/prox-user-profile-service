package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorSprechzeiten {

    private String sprechzeiten;

    private static int MAX_LENGTH = 64;

    public ProfessorSprechzeiten() {}

    public ProfessorSprechzeiten(String sprechzeiten)
    {
        if(!isValid(sprechzeiten))
        {
            throw new IllegalArgumentException(
                    String.format("FirstName %s exceeded maximum number of %d allowed characters", sprechzeiten,
                            MAX_LENGTH));

        }
        this.sprechzeiten = sprechzeiten.trim();
    }

    private boolean isValid(String sprechzeiten)
    {
        return sprechzeiten != null && sprechzeiten.length() <= MAX_LENGTH;
    }
}
