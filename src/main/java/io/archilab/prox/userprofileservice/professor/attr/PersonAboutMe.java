package io.archilab.prox.userprofileservice.professor.attr;

import javax.persistence.Embeddable;

import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class PersonAboutMe {

    private static final int MAX_LENGTH = 3000;

    @Getter
    private boolean hasAboutMe;

    @Getter
    private String aboutMe;

    public PersonAboutMe(String description)
    {
        if(!PersonAboutMe.isValid(description))
        {
            throw new IllegalArgumentException(
                    String.format("Name %s exceeded maximum number of %d allowed characters", description,
                            PersonAboutMe.MAX_LENGTH));
        }
        if(description.equals(""))
        {
            //this.description = "NULL";
            hasAboutMe = false;
        }
        else
        {
            this.aboutMe = description;
            hasAboutMe = true;
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
                aboutMe);
    }
}
