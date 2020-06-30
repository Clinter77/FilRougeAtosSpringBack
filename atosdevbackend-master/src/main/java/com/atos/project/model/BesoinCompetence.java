package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
//import model.MyJsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "besoin_competence")
@EntityListeners(AuditingEntityListener.class)
@IdClass(BesoinCompetence.PK.class)

public class BesoinCompetence {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBsn", referencedColumnName = "id_bsn")
    @JsonView({MyJsonView.Besoin.class,MyJsonView.BesoinCompetence.class})
    private Besoin besoin;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCpc", referencedColumnName = "idCpc")
    @JsonView({MyJsonView.Besoin.class,MyJsonView.BesoinCompetence.class})
    private Competence competence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idExp", referencedColumnName = "id_exp")
    @JsonView({MyJsonView.Besoin.class,MyJsonView.BesoinCompetence.class})
    private Experience experience;

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Besoin getBesoin() {
        return besoin;
    }

    public void setBesoin(Besoin besoin) {
        this.besoin = besoin;
    }

    //	@Embeddable
    public static class PK implements Serializable {
        //        @JsonView({MyJsonView.BesoinCompetence.class})
//		@Column(name = "idBsn")
        int besoin;
        //		@Column(name = "idCpc")
        int competence;

        public int getCompetence() {
            return competence;
        }

        public void setCompetence(int competence) {
            this.competence = competence;
        }

        public int getBesoin() {
            return besoin;
        }

        public void setBesoin(int besoin) {
            this.besoin = besoin;
        }
    }
}
