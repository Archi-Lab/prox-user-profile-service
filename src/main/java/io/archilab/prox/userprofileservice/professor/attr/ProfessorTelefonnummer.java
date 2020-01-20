package io.archilab.prox.userprofileservice.professor.attr;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Setter(AccessLevel.NONE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorTelefonnummer {

    private long telefonnummer;

    public ProfessorTelefonnummer(long telefonnummer)
    {
        this.telefonnummer = telefonnummer;
    }
}
