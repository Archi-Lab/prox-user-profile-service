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
public class StudentSchwerpunkt
{
    private String schwerpunkt;
    private static final int MAX_LENGTH = 255;


    public StudentSchwerpunkt(String schwerpunkt)
    {
        if(!isValid(schwerpunkt))
        {
            throw new IllegalArgumentException(
                    String.format("Schwerpunkt %s exceeded maximum number of %d allowed characters", schwerpunkt,
                            MAX_LENGTH));
        }
        this.schwerpunkt = schwerpunkt;
    }

    public static boolean isValid(String schwerpunkt)
    {
        if(schwerpunkt.equals(""))
        {
            return true;
        }
        return schwerpunkt.length() <= MAX_LENGTH ;
    }
}
