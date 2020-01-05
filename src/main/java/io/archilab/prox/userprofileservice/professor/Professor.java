package io.archilab.prox.userprofileservice.professor;

import io.archilab.prox.userprofileservice.modul.Modul;
import io.archilab.prox.userprofileservice.project.Projekt;
import io.archilab.prox.userprofileservice.tag.Tag;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

public class Professor
{
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Title title;
    private String raum;
    private long telefonnummer;
    private String email;
    private String sprechzeiten;
    private String bildSrc;
    private Fachgebiet fachgebiet;
    private ProfessorDescription description;

    @DBRef(lazy = true)
    private List<Projekt> projekts_ids;

    @DBRef(lazy = true)
    private List<Modul> moduls_ids;

    @DBRef(lazy = true)
    private List<Tag> tags_ids;



    public Professor() {}

    public Professor(String firstName, String lastName, Title title, String raum, long telefonnummer, String email, String sprechzeiten, String bildSrc, Fachgebiet fachgebiet, ProfessorDescription description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.raum = raum;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.sprechzeiten = sprechzeiten;
        this.bildSrc = bildSrc;
        this.fachgebiet = fachgebiet;
        this.description = description;
        this.projekts_ids=new ArrayList<>();
        this.moduls_ids=new ArrayList<>();
        this.tags_ids=new ArrayList<>();
    }

    public Professor(String firstName, String lastName, ProfessorDescription description)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.projekts_ids=new ArrayList<>();
        this.moduls_ids=new ArrayList<>();
        this.tags_ids=new ArrayList<>();
    }

    @Override
    public String toString() {
        String basis = "Professor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description=" + description +
                ", projekte=" + projekts_ids.toString() +
                ", projekte=[";
        for(Projekt projekt:this.projekts_ids){
            basis+=projekt.toString();
        }
        basis+="]";

        return basis+='}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public long getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(long telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSprechzeiten() {
        return sprechzeiten;
    }

    public void setSprechzeiten(String sprechzeiten) {
        this.sprechzeiten = sprechzeiten;
    }

    public String getBildSrc() {
        return bildSrc;
    }

    public void setBildSrc(String bildSrc) {
        this.bildSrc = bildSrc;
    }

    public Fachgebiet getFachgebiet() {
        return fachgebiet;
    }

    public void setFachgebiet(Fachgebiet fachgebiet) {
        this.fachgebiet = fachgebiet;
    }

    public ProfessorDescription getDescription() {
        return description;
    }

    public void setDescription(ProfessorDescription description) {
        this.description = description;
    }

    public List<Projekt> getProjekts_ids() {
        return projekts_ids;
    }

    public void setProjekts_ids(List<Projekt> projekts_ids) {
        this.projekts_ids = projekts_ids;
    }

    public List<Modul> getModuls_ids() {
        return moduls_ids;
    }

    public void setModuls_ids(List<Modul> moduls_ids) {
        this.moduls_ids = moduls_ids;
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
        tag.addProfessor(this);
    }

    public void addProjekt(Projekt projekt) {
        if(projekts_ids.contains(projekt))return;
        projekts_ids.add(projekt);
        projekt.addProfessor(this);
    }

    public void addModul(Modul modul) {
        if(moduls_ids.contains(modul))return;
        moduls_ids.add(modul);
        modul.addProfessor(this);
    }
}