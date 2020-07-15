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
import java.util.Set;


@Entity
@Table(name="site")
@EntityListeners(AuditingEntityListener.class)
public class Site {
    @Id
//    @Column(name="id_sit")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class, MyJsonView.Contact.class})
    private Integer idSit;



    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class, MyJsonView.Contact.class})
    private String lib;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String adr;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    @Column(name ="code_postal")
    private String codePostal;

    @Size(max = 100)
    @Email
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String email;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String tel1;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String tel2;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String fax;

    @Size(max = 100)
    @JsonView({MyJsonView.SiteClient.class,MyJsonView.Besoin.class})
    private String ville;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "idclient")
    @JsonView({MyJsonView.Client.class,MyJsonView.Besoin.class, MyJsonView.SiteClient.class})
    private Client clientSite;

    public Integer getIdSit() {
        return idSit;
    }

    public void setIdSit(Integer idSit) {
        this.idSit = idSit;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Client getClientSite() {
        return clientSite;
    }

    public void setClientSite(Client clientSite) {
        this.clientSite = clientSite;
    }
}
