package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name="agence")
@EntityListeners(AuditingEntityListener.class)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private int idAgc;
    @Column(unique = true)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Collaborateur.class,MyJsonView.CollaborateurCompetence.class})
    private String lib;

    public Integer getId() {
        return idAgc;
    }
    public void setId(Integer id) { this.idAgc = idAgc; }
    public String getLib() {
        return lib;
    }
    public void setLib(String lib) {
        this.lib = lib;
    }

}
