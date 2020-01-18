package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorBildSrc {

    private String bildSrc;
    private boolean hasBild;

    private static final int MAX_LENGTH = 255;


    public ProfessorBildSrc(String bildSrc)
    {
        if(!isValid(bildSrc))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", bildSrc,
                            MAX_LENGTH));
        }
        if(bildSrc.equals(""))
        {
            //this.bildSrc = "NULL";
            hasBild = false;
        }
        else
        {
            this.bildSrc = bildSrc;
            hasBild = true;
        }
    }

    public static boolean isValid(String bildSrc)
    {
        if(bildSrc.equals(""))
        {
            return true;
        }
        return bildSrc.length() <= MAX_LENGTH ;
    }

}
