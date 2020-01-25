package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorPlz
{
    private static final int MAX_LENGTH = 63;

    @Getter
    private String plz;

    public ProfessorPlz(String plz)
    {
        if(!PersonAboutMe.isValid(plz))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", plz,
                            MAX_LENGTH));
        }
        this.plz = plz;
    }

    public static boolean isValid(String plz)
    {
        if(plz.equals(""))
        {
            return true;
        }
        return plz.length() <= MAX_LENGTH ;
    }
}
