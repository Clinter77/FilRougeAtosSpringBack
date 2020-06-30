package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Experience")
@EntityListeners(AuditingEntityListener.class)
public class Experience {

    @Column(name = "id_exp")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({
            MyJsonView.Experience.class,
            MyJsonView.Collaborateur.class,
            MyJsonView.CollaborateurCompetence.class,
            MyJsonView.BesoinCompetence.class
    })
    private Integer idExp;

    @Column(name = "lib")
    @Size(max = 11)
    @JsonView({
            MyJsonView.Experience.class,
            MyJsonView.Collaborateur.class,
            MyJsonView.CollaborateurCompetence.class,
            MyJsonView.BesoinCompetence.class
    })
    private String lib;

    public Integer getId() {
        return idExp;
    }

    public void setId(Integer id) {
        this.idExp = idExp;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

}
