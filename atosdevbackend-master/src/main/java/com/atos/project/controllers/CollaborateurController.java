package com.atos.project.controllers;

import com.atos.project.model.Collaborateur;
import com.atos.project.security.services.CollaborateurCompetenceService;
import com.atos.project.security.services.CollaborateurService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollaborateurController {

    CollaborateurService collaborateurService;

    @Autowired
    public CollaborateurController(final CollaborateurService collaborateurService) {
        this.collaborateurService = collaborateurService;
    }

    /**
     * Api ENDPOINT GET liste de Collaborateur
     * @return
     */
    @GetMapping("/clb")
    @JsonView(MyJsonView.Collaborateur.class)
    public List<Collaborateur> showCollaborateur() {
        return this.collaborateurService.findAll();
    }

    /**
     * RestApi Controler url Get pour AJOUTER un Collaborateur avec l'id
     * @param id
     * @return
     */
    @GetMapping("/clb/{id}")
    @JsonView(MyJsonView.Collaborateur.class)
    public Collaborateur getCollab(@PathVariable int id) {
        return (Collaborateur) this.collaborateurService.findById(id);
    }


    /**
     * RestApi Controler url PUT pour AJOUTER un Collaborateur
     * @param collaborateur
     * @return
     */
    @PutMapping("/addclb")
    public Collaborateur addcollab(@RequestBody Collaborateur collaborateur) {
        collaborateur = this.collaborateurService.save(collaborateur);
        if (collaborateur.getListeCollaborateurCompetence().size() > 0) {
            Collaborateur finalCollaborateur = collaborateur;
            collaborateur.getListeCollaborateurCompetence().stream().forEach(collaborateurCompetence -> {
                collaborateurCompetence.setCollaborateur(finalCollaborateur);
            });
        }
        return this.collaborateurService.save(collaborateur);
    }

    /**
     * Api Endpoint url DELETE pour Supprimer un Collaborateur pad son ID
     * @param id
     */
    @DeleteMapping("/delclb/{id}")
    public void delete(@PathVariable int id) {

        this.collaborateurService.delete(id);
    }
}
