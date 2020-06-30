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
@Table(name = "collaborateur_competence")
@EntityListeners(AuditingEntityListener.class)
@IdClass(CollaborateurCompetence.PK.class)
public class CollaborateurCompetence {
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idClb", referencedColumnName = "id_clb")
	@JsonView({MyJsonView.CollaborateurCompetence.class})
	private Collaborateur collaborateur;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCpc", referencedColumnName = "idCpc")
	@JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
	private Competence competence;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idExp", referencedColumnName = "id_exp")
	@JsonView({MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
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
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

//	@Embeddable
	public static class PK implements Serializable {
		@JsonView({MyJsonView.CollaborateurCompetence.class})
//		@Column(name = "idClb")
		int collaborateur;
//		@Column(name = "idCpc")
		int competence;

		public int getCompetence() {
			return competence;
		}
		public void setCompetence(int competence) {
			this.competence = competence;
		}
		public int getCollaborateur() {
			return collaborateur;
		}
		public void setCollaborateur(int collaborateur) {
			this.collaborateur = collaborateur;
		}
	}

}
