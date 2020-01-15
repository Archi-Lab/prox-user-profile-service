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

    public ProfessorBildSrc() {}

    public ProfessorBildSrc(String bildSrc)
    {
        hasBild = hasBild(bildSrc);
        this.bildSrc = bildSrc;
    }

    private boolean hasBild(String bildSrc)
    {
        return bildSrc != null;
    }

}
