package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonMail {

    private String mail;

    private static int MAX_LENGTH = 127;

    public PersonMail(String email)
    {
        if(!isValid(email))
        {
            throw new IllegalArgumentException( String.format("Email %s exceeded maximum number of %d allowed characters", email,
                    MAX_LENGTH));
        }
        this.mail = email;
    }

    private boolean isValid(String email)
    {
        boolean valid = email != null && email.length() <= MAX_LENGTH;

        //RFC 5322
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern patt = Pattern.compile(regex);

        if(email != null)
        {
            Matcher matcher = patt.matcher(email);
            return valid && matcher.matches();
        }
        else
        {
            throw new IllegalArgumentException( String.format("Email is empty"));
        }

    }
}
