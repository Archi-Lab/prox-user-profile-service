package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonPhoneNumber {

    private long phonenumber;

    public PersonPhoneNumber(long phonenumber)
    {
        this.phonenumber = phonenumber;
    }
}
