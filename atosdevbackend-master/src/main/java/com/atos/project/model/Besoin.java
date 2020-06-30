package com.atos.project.model;


import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Besoin")
@EntityListeners(AuditingEntityListener.class)
public class Besoin {

    @Column(name = "id_bsn")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,


    })
    private Integer id;

    @Column(name = "d_debut")
    @Temporal(TemporalType.DATE)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,

    })
    Date d_debut;

    @Column(name = "intitule")
    @Size(max = 250)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,

    })
    private String intitule;

    @Column(name = "d_echeance")
    @Temporal(TemporalType.DATE)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,

    })
    Date d_echeance;

    // Site
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSit")
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Proposition.class,

    })
    private Site site;

    // Contact
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ctc")
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Contact.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Proposition.class,

    })
    private ContactClient contactClient;

    @CreationTimestamp
    @Column(name = "ts")
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,

    })
    private Date ts;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usr")
    @JsonView({MyJsonView.Besoin.class, MyJsonView.Utilisateur.class, MyJsonView.BesoinCompetence.class })
    private User user;*/

    @Column(name = "remarque")
    @Size(max = 1000)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,

    })
    private String remarque;

    @Column(name = "f_cloture")
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,
    })
    private boolean fCloture;


    @Column(name = "f_recurent")
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.BesoinCompetence.class,
            MyJsonView.Client.class,
            MyJsonView.Proposition.class,
    })
    private boolean fRecurent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getD_debut() {
        return d_debut;
    }

    public void setD_debut(Date d_debut) {
        this.d_debut = d_debut;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getD_echeance() {
        return d_echeance;
    }

    public void setD_echeance(Date d_echeance) {
        this.d_echeance = d_echeance;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public ContactClient getContactClient() {
        return contactClient;
    }

    public void setContactClient(ContactClient contactClient) {
        this.contactClient = contactClient;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public boolean isfCloture() {
        return fCloture;
    }

    public void setfCloture(boolean fCloture) {
        this.fCloture = fCloture;
    }

    public boolean isfRecurent() {
        return fRecurent;
    }

    public void setfRecurent(boolean fRecurent) {
        this.fRecurent = fRecurent;
    }


}
