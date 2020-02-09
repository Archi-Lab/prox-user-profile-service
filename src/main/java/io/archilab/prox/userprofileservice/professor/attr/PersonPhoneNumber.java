package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonPhoneNumber {

    private String phonenumber;

    public PersonPhoneNumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
}
