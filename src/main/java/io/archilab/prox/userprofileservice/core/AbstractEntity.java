package io.archilab.prox.userprofileservice.core;

import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.archilab.prox.userprofileservice.professor.attr.PersonFirstName;
import io.archilab.prox.userprofileservice.professor.attr.PersonLastName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@MappedSuperclass
@Data
@Setter(AccessLevel.NONE)
public abstract class AbstractEntity {

    @Id
    private UUID id;


    protected AbstractEntity() {
        this.id = UUID.randomUUID();
    }
}