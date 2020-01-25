package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorStrasse
{
    private static final int MAX_LENGTH = 255;

    @Getter
    private String strasse;

    public ProfessorStrasse(String strasse)
    {
        if(!PersonAboutMe.isValid(strasse))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", strasse,
                            MAX_LENGTH));
        }
        this.strasse = strasse;
    }

    public static boolean isValid(String strasse)
    {
        if(strasse.equals(""))
        {
            return true;
        }
        return strasse.length() <= MAX_LENGTH ;
    }
}
