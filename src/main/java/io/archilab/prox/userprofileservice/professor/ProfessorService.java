package io.archilab.prox.userprofileservice.professor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService implements IProfessorService{

    @Autowired
    private ProfessorRepository repository;

    @Override
    public List<Professor> findAll() {

        List<Professor> professors = (List<Professor>) repository.findAll();

        return professors;
    }
}
