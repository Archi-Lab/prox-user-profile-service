package io.archilab.prox.userprofileservice.project;

import io.archilab.prox.userprofileservice.professor.Professor;
import io.archilab.prox.userprofileservice.tag.Tag;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Projekt
{
    @Id
    private String id;

    private String name;
    private String kurzbeschreibung;
    private String beschreibung;
    private Projektart projektart;
    private Status status;
    private int teilnehmerzahl;

    @DBRef(lazy = true)
    private List<Professor> professors_ids;

    @DBRef(lazy = true)
    private List<Tag> tags_ids;



    public Projekt() {}

    public Projekt(String name, String kurzbeschreibung, String beschreibung, Projektart projektart, Status status, int teilnehmerzahl) {
        this.name = name;
        this.kurzbeschreibung = kurzbeschreibung;
        this.beschreibung = beschreibung;
        this.projektart = projektart;
        this.status = status;
        this.teilnehmerzahl = teilnehmerzahl;
        this.professors_ids=new ArrayList<>();
        this.tags_ids=new ArrayList<>();
    }

    @Override
    public String toString() {
        String basis =  "Projekt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", projektart=" + projektart + '\''+
                ", professor=[";

        for(Professor professor:professors_ids){
            basis+=professor.getFirstName();
        }
        basis+=']';
        return basis+='}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKurzbeschreibung() {
        return kurzbeschreibung;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Projektart getProjektart() {
        return projektart;
    }

    public Status getStatus() {
        return status;
    }

    public int getTeilnehmerzahl() {
        return teilnehmerzahl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKurzbeschreibung(String kurzbeschreibung) {
        this.kurzbeschreibung = kurzbeschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setProjektart(Projektart projektart) {
        this.projektart = projektart;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTeilnehmerzahl(int teilnehmerzahl) {
        this.teilnehmerzahl = teilnehmerzahl;
    }

    public List<Professor> getProfessors_ids() {
        return professors_ids;
    }

    public void setProfessors_ids(List<Professor> professors_ids) {
        this.professors_ids = professors_ids;
    }

    public List<Tag> getTags_ids() {
        return tags_ids;
    }

    public void setTags_ids(List<Tag> tags_ids) {
        this.tags_ids = tags_ids;
    }

    public void addTag(Tag tag) {
        if(tags_ids.contains(tag))return;
        tags_ids.add(tag);
        tag.addProjekt(this);
    }

    public void addProfessor(Professor professor){
        if(professors_ids.contains(professor))return;
        professors_ids.add(professor);
        professor.addProjekt(this);
    }
}