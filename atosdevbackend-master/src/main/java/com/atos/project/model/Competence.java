package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "competence")
@EntityListeners(AuditingEntityListener.class)
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Competence.class,
            MyJsonView.Collaborateur.class,
            MyJsonView.CollaborateurCompetence.class,
            MyJsonView.Contact.class,
            MyJsonView.BesoinCompetence.class
    })
    private int idCpc;

    @Column(unique = true)
    @JsonView({
            MyJsonView.Competence.class,
            MyJsonView.Collaborateur.class,
            MyJsonView.CollaborateurCompetence.class,
            MyJsonView.Contact.class,
            MyJsonView.BesoinCompetence.class
    })
    private String lib;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTcp")
    @JsonView({MyJsonView.Competence.class, MyJsonView.BesoinCompetence.class})
    private TypeCompetence typeCompetence;

    @ManyToMany(mappedBy = "listeCompetence",cascade = CascadeType.ALL)
    @JsonView({MyJsonView.Competence.class, MyJsonView.BesoinCompetence.class})
    Set<ContactClient> listeContactClient;
//    @ManyToMany
//    @JoinTable(
//            name = "contact_competence",
//            joinColumns = @JoinColumn(name = "id_cpc"),
//            inverseJoinColumns = @JoinColumn(name = "id_ctc"))
//    Set<ContactClient> listeContactClient;

    public int getIdCpc() {
        return idCpc;
    }

    public void setIdCpc(int idCpc) {
        this.idCpc = idCpc;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public TypeCompetence getTypeCompetence() {
        return typeCompetence;
    }

    public void setTypeCompetence(TypeCompetence typeCompetence) {
        this.typeCompetence = typeCompetence;
    }

    public Set<ContactClient> getListeContactClient() {
        return listeContactClient;
    }

    public void setListeContactClient(Set<ContactClient> listeContactClient) {
        this.listeContactClient = listeContactClient;
    }
}