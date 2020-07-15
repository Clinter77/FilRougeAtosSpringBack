package com.atos.project.controllers;

import com.atos.project.model.BesoinCompetence;
import com.atos.project.security.services.BesoinCompetenceService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BesoinCompetenceController {
    BesoinCompetenceService besoinCompetenceService;

    @Autowired
    public BesoinCompetenceController(final BesoinCompetenceService besoinCompetenceServiceService) {
        this.besoinCompetenceService = besoinCompetenceServiceService;
    }

    /**
     * Api Endpoint GET Pour Lister les Besoins D'un clients
     * @return
     */
    @GetMapping("/bsn_cpc")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public List<BesoinCompetence> showclb_cpc() {
        return this.besoinCompetenceService.findAll();
    }

    /**
     * Api Endpoint GET Pour Lister les Besoins de Competence D'un client
     * par son attribut ID
     * @param id
     * @return
     */
    @GetMapping("/bsn_cpc/{id}")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public BesoinCompetence getclb_cpc(@PathVariable int id) {
        return (BesoinCompetence) this.besoinCompetenceService.findById(id);
    }

    /**
     * Api EndPoint PUT pour Ajouter un BesoinCompetence
     * @param besoinCompetence
     * @return
     */
    @PutMapping("/addbsn_cpc")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public BesoinCompetence addcollab(@RequestBody BesoinCompetence besoinCompetence) {
        return this.besoinCompetenceService.save(besoinCompetence);
    }


    /**
     * Api EndPoint DELETE pour supprimer un BesoinCompetence
     * @param id
     */
    @DeleteMapping("/delbsn_cpc/{id}")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public void delete(@PathVariable int id) {
        this.besoinCompetenceService.delete(id);
    }
    
}
