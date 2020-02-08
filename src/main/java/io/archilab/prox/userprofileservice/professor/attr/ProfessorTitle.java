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
public class ProfessorTitle {

    private static final int MAX_LENGTH = 127;

    private String title;

    public ProfessorTitle(String title) {
        if(!isValid(title)) {
            throw new IllegalArgumentException(
                    String.format("Title %s exceeded maximum number of %d allowed characters", title,
                            MAX_LENGTH));
        }
        this.title = title.trim();
    }

    public static boolean isValid(String title) {
        return title != null && title.length() <= MAX_LENGTH;
    }
}
