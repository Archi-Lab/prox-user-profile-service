package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorEmail {

    private String email;

    private static int MAX_LENGTH = 127;

    public ProfessorEmail() {}

    public ProfessorEmail(String email)
    {
        if(!isValid(email))
        {
            this.email = email;
        }
    }

    private boolean isValid(String email)
    {
        return email != null && email.length() <= MAX_LENGTH;
    }
}
