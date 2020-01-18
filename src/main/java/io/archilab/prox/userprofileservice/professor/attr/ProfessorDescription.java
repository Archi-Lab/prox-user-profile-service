package io.archilab.prox.userprofileservice.professor.attr;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@Getter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ProfessorDescription {

    private static final int MAX_LENGTH = 3000;

    @Getter
    private boolean hasDescription;

    @Getter
    private String description;

    public ProfessorDescription(String description)
    {
        if(!ProfessorDescription.isValid(description))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", description,
                            ProfessorDescription.MAX_LENGTH));
        }
        if(description.equals(""))
        {
            //this.description = "NULL";
            hasDescription = false;
        }
        else
        {
            this.description = description;
            hasDescription = true;
        }
    }

    public static boolean isValid(String description)
    {
        if(description.equals(""))
        {
            return true;
        }
        return description.length() <= MAX_LENGTH ;
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s",
                description);
    }
}
