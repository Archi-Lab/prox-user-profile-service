package io.archilab.prox.userprofileservice.module;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface StudyCourseRepository extends PagingAndSortingRepository<StudyCourse, UUID> {

  List<StudyCourse> findByAcademicDegree(AcademicDegree academicDegree);

}
