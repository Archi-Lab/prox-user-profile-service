package io.archilab.prox.userprofileservice.tag;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.project.Projekt;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Tag
{
    @Id
    private String id;

    private String beschreibung;

    @DBRef(lazy = true)
    private List<Projekt> projekts_ids;

    @DBRef(lazy = true)
    private List<Professor> professors_ids;

    public Tag(String beschreibung) {
        this.beschreibung = beschreibung;
        this.professors_ids=new ArrayList<>();
        this.projekts_ids=new ArrayList<>();
    }

    @Override
    public String toString()
    {
        return String.format("id: %s, beschreibung: %s", id, beschreibung);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void addProfessor(Professor professor){
        if(professors_ids.contains(professor))return;
        professors_ids.add(professor);
        professor.addTag(this);
    }

    public void addProjekt(Projekt projekt){
        if(projekts_ids.contains(projekt))return;
        projekts_ids.add(projekt);
        projekt.addTag(this);
    }


}
