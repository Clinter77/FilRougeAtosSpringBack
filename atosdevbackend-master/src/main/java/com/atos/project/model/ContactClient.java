package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="contact_client")
@EntityListeners(AuditingEntityListener.class)

public class ContactClient {
    @Id
    @Column(name="id_ctc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private Integer id;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String nom;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String prenom;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String poste;

    @Size(max = 100)
    @Email
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String email;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String tel1;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String tel2;

    @Size(max = 100)
    @JsonView({MyJsonView.Contact.class, MyJsonView.Besoin.class, MyJsonView.BesoinCompetence.class})
    private String fax;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="id_sit")
    @JsonView({MyJsonView.Contact.class, MyJsonView.BesoinCompetence.class})
    private Site site;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinTable(
            name = "contact_competence",
            joinColumns = @JoinColumn(name = "id_ctc"),
            inverseJoinColumns = @JoinColumn(name = "id_cpc"))
    @JsonView({MyJsonView.Contact.class})
    Set<Competence> listeCompetence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<Competence> getListeCompetence() {
        return listeCompetence;
    }

    public void setListeCompetence(Set<Competence> listeCompetence) {
        this.listeCompetence = listeCompetence;
    }

}
