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
public class StudentStatus
{
    private String status;
    private static final int MAX_LENGTH = 255;


    public StudentStatus(String status)
    {
        if(!isValid(status))
        {
            throw new IllegalArgumentException(
                    String.format("Status %s exceeded maximum number of %d allowed characters", status,
                            MAX_LENGTH));
        }
        this.status = status;
    }

    public static boolean isValid(String status)
    {
        if(status.equals(""))
        {
            return true;
        }
        return status.length() <= MAX_LENGTH ;
    }
}
