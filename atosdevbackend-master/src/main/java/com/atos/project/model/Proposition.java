package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Proposition")
@EntityListeners(AuditingEntityListener.class)
public class Proposition {

    @Column(name = "id_pro")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idBsn")
    @JsonView({MyJsonView.Proposition.class})
    private Besoin besoin;

    @Column(name="d_pro")
    @Temporal(TemporalType.DATE)
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private Date d_pro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClb")
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private Collaborateur collaborateur;

    @Column
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private float prixAchat;

    @Column
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private float prixVente;

    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private float marge;

    @Column(name="d_relance")
    @Temporal(TemporalType.DATE)
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private Date d_relance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @JsonView(MyJsonView.Proposition.class)
    private User user;

    @CreationTimestamp
    @Column(name="ts", nullable = false, updatable = false, insertable = false)
    @JsonView({MyJsonView.Proposition.class,MyJsonView.Besoin.class})
    private Date ts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSpr")
    @JsonView({MyJsonView.Proposition.class, MyJsonView.Besoin.class})
    private StatutProposition statut_prop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Besoin getBesoin() {
        return besoin;
    }

    public void setBesoin(Besoin besoin) {
        this.besoin = besoin;
    }

    public Date getD_pro() {
        return d_pro;
    }

    public void setD_pro(Date d_pro) {
        this.d_pro = d_pro;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public float getMarge() {
        return marge;
    }

    public void setMarge(float marge) {
        this.marge = marge;
    }

    public Date getD_relance() {
        return d_relance;
    }

    public void setD_relance(Date d_relance) {
        this.d_relance = d_relance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public StatutProposition getStatut_prop() {
        return statut_prop;
    }

    public void setStatut_prop(StatutProposition statut_prop) {
        this.statut_prop = statut_prop;
    }


}
