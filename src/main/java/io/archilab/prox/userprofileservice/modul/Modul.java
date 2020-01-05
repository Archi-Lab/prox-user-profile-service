package io.archilab.prox.userprofileservice.modul;

import io.archilab.prox.userprofileservice.professor.Professor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Modul
{
    @Id
    private String id;

    private String name;

    @DBRef(lazy = true)
    private List<Professor> professors_ids;

    public Modul(String id, String name) {
        this.id = id;
        this.name = name;
        professors_ids=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProfessor(Professor professor){
        if(professors_ids.contains(professor))return;
        professors_ids.add(professor);
        professor.addModul(this);
    }
}
