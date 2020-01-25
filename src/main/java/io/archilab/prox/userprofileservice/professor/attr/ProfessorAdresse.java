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
public class ProfessorAdresse
{
    private String adresse;
    private static final int MAX_LENGTH = 255;


    public ProfessorAdresse(String adresse)
    {
        if(!isValid(adresse))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", adresse,
                            MAX_LENGTH));
        }
        this.adresse = adresse;
    }

    public static boolean isValid(String adresse)
    {
        if(adresse.equals(""))
        {
            return true;
        }
        return adresse.length() <= MAX_LENGTH ;
    }
}
