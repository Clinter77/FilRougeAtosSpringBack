package com.atos.project.model;

import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Client")
@EntityListeners(AuditingEntityListener.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private Integer idClient;

    @Size(max = 100)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private String lib;

    @Size(max = 100)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class,MyJsonView.SiteClient.class})
    private String adr;

    @Size(max = 100)
    @Column(name ="code_postal")
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private String codePostal;

    @Size(max = 100)
    @Email
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private String email;

    @Size(max = 100)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private String tel1;

    @Size(max = 100)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class,MyJsonView.SiteClient.class})
    private String fax;

    @Size(max = 100)
    @JsonView({MyJsonView.Besoin.class,MyJsonView.Client.class,MyJsonView.SiteClient.class})
    private String ville;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "idbsn")
    @JsonView({MyJsonView.Client.class, MyJsonView.SiteClient.class})
    private Besoin besoinClient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "idprops")
    @JsonView({MyJsonView.Client.class, MyJsonView.SiteClient.class, MyJsonView.Besoin.class})
    private Proposition props;

    public Client() {}

    public Client(Integer idClient, String lib, String adr,  String codePostal,  String email, String tel1,  String fax,  String ville) {
        this.idClient = idClient;
        this.lib = lib;
        this.adr = adr;
        this.codePostal = codePostal;
        this.email = email;
        this.tel1 = tel1;
        this.fax = fax;
        this.ville = ville;
    }


    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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


    public Besoin getBesoinClient() {
        return besoinClient;
    }

    public void setBesoinClient(Besoin besoinClient) {
        this.besoinClient = besoinClient;
    }
}
