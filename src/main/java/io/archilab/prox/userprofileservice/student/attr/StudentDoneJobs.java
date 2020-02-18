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
public class StudentDoneJobs
{
    private String doneJobs
            ;
    private static final int MAX_LENGTH = 511;


    public StudentDoneJobs(String doneJobs)
    {
        if(!isValid(doneJobs))
        {
            throw new IllegalArgumentException(
                    String.format("doneJobs %s exceeded maximum number of %d allowed characters", doneJobs,
                            MAX_LENGTH));
        }
        this.doneJobs = doneJobs;
    }

    public static boolean isValid(String doneJobs)
    {
        if(doneJobs.equals(""))
        {
            return true;
        }
        return doneJobs.length() <= MAX_LENGTH ;
    }
}
