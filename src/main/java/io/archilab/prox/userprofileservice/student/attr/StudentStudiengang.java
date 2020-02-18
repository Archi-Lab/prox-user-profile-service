package io.archilab.prox.userprofileservice.student.attr;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentStudiengang
{
    private String studiengang;
    private static final int MAX_LENGTH = 255;


    public StudentStudiengang(String studiengang)
    {
        if(!isValid(studiengang))
        {
            throw new IllegalArgumentException(
                    String.format("Studiengang %s exceeded maximum number of %d allowed characters", studiengang,
                            MAX_LENGTH));
        }
        this.studiengang = studiengang;
    }

    public static boolean isValid(String studiengang)
    {
        if(studiengang.equals(""))
        {
            return true;
        }
        return studiengang.length() <= MAX_LENGTH ;
    }
}
