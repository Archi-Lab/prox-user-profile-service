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
public class PersonName {

    private static final int MAX_LENGTH = 127;

    private String name;

    public PersonName(String name) {
        if(!isValid(name)) {
            throw new IllegalArgumentException(
                    String.format("FirstName %s exceeded maximum number of %d allowed characters", name,
                            PersonName.MAX_LENGTH));
        }
        this.name = name.trim();
    }

    public static boolean isValid(String name) {
        return name != null && name.length() <= PersonName.MAX_LENGTH;
    }
}
