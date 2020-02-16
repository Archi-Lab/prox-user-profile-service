package io.archilab.prox.userprofileservice.module;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.archilab.prox.userprofileservice.core.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Module extends AbstractEntity {

  @Setter
  @JsonUnwrapped
  private ModuleName name;
  //
  // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "modules")
  // private Set<StudyCourse> studyCourses = new HashSet<>();
  //

  @Setter
  @JsonUnwrapped
  private ModuleDescription description;

  public Module(ModuleName name, ModuleDescription description) {
    this.name = name;
    this.description = description;
  }

}
