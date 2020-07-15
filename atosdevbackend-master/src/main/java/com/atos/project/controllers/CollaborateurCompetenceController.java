package com.atos.project.controllers;

import com.atos.project.model.CollaborateurCompetence;
import com.atos.project.security.services.CollaborateurCompetenceService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CollaborateurCompetenceController {
    CollaborateurCompetenceService collaborateurCompetenceService;

    @Autowired
    public CollaborateurCompetenceController(final CollaborateurCompetenceService collaborateurCompetenceServiceService) {
        this.collaborateurCompetenceService = collaborateurCompetenceServiceService;
    }


    /**
     * Api ENDPOINT GET retourne un Liste de collaborateur
     * Competence
     * @return
     */
    @GetMapping("/clb_cpc")
    @JsonView(MyJsonView.CollaborateurCompetence.class)
    public List<CollaborateurCompetence> showclb_cpc() {
        return this.collaborateurCompetenceService.findAll();
    }

    /**
     * Api ENDPOINT GET retourne un Liste de collaborateur
     * Competence par L'id
     * @param id
     * @return
     */
    @GetMapping("/clb_cpc/{id}")
    @JsonView(MyJsonView.CollaborateurCompetence.class)
    public CollaborateurCompetence getclb_cpc(@PathVariable int id) {
        return (CollaborateurCompetence) this.collaborateurCompetenceService.findById(id);
    }

    /**
     * Api ENDPOINT PUT pour Ajouter un Collobarateur Competence
     * @param collaborateurCompetence
     * @return
     */
    @PutMapping("/addclb_cpc")
    @JsonView(MyJsonView.CollaborateurCompetence.class)
    public CollaborateurCompetence addcollab(@RequestBody CollaborateurCompetence collaborateurCompetence) {
        return this.collaborateurCompetenceService.save(collaborateurCompetence);
    }

    /**
     * Api ENDPOINT DELETE  pour Supprimer un Collobarateur Competence
     * @param id
     */
    @DeleteMapping("/delclb_cpc/{id}")
    @JsonView(MyJsonView.CollaborateurCompetence.class)
    public void delete(@PathVariable int id) {
        this.collaborateurCompetenceService.delete(id);
    }
}
