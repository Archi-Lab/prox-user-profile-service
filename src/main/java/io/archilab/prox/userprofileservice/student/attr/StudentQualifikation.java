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
public class StudentQualifikation
{
    private String qualifikation;
    private static final int MAX_LENGTH = 255;


    public StudentQualifikation(String qualifikation)
    {
        if(!isValid(qualifikation))
        {
            throw new IllegalArgumentException(
                    String.format("Qualifikation %s exceeded maximum number of %d allowed characters", qualifikation,
                            MAX_LENGTH));
        }
        this.qualifikation = qualifikation;
    }

    public static boolean isValid(String qualifikation)
    {
        if(qualifikation.equals(""))
        {
            return true;
        }
        return qualifikation.length() <= MAX_LENGTH ;
    }
}
