package io.archilab.prox.userprofileservice.module;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ModuleRepository extends PagingAndSortingRepository<Module, UUID> {

  Page<Module> findByName_NameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

}
