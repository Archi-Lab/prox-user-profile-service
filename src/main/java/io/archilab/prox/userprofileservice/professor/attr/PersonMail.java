package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonMail {

    private String email;

    private static int MAX_LENGTH = 127;

    public PersonMail(String email)
    {
        if(!isValid(email))
        {
            throw new IllegalArgumentException( String.format("Email %s exceeded maximum number of %d allowed characters", email,
                    MAX_LENGTH));
        }
        this.email = email;
    }

    private boolean isValid(String email)
    {
        return email != null && email.length() <= MAX_LENGTH;
    }
}
