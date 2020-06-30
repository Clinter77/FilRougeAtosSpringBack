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

    /*******************************************************
     *                      List of BesoinCompetence
     *******************************************************/
    @GetMapping("/bsn_cpc")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public List<BesoinCompetence> showclb_cpc() {
        return this.besoinCompetenceService.findAll();
    }

    @GetMapping("/bsn_cpc/{id}")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public BesoinCompetence getclb_cpc(@PathVariable int id) {
        return (BesoinCompetence) this.besoinCompetenceService.findById(id);
    }

    /*******************************************************
     *                     Add BesoinCompetence
     *******************************************************/
    @PutMapping("/addbsn_cpc")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public BesoinCompetence addcollab(@RequestBody BesoinCompetence besoinCompetence) {
        return this.besoinCompetenceService.save(besoinCompetence);
    }

    /******************************************************
     *                      Delete BesoinCompetence
     *******************************************************/

    @DeleteMapping("/delbsn_cpc/{id}")
    @JsonView(MyJsonView.BesoinCompetence.class)
    public void delete(@PathVariable int id) {
        this.besoinCompetenceService.delete(id);
    }
    
}
