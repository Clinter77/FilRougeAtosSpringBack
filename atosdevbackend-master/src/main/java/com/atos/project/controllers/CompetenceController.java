package com.atos.project.controllers;

import com.atos.project.model.Competence;
import com.atos.project.security.services.CompetenceService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CompetenceController {
    
    CompetenceService competenceService;
    
    @Autowired
    public CompetenceController(final CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    /**
     * Api Endpoint url Get retourne un list de Competences
     * @return
     */
    @GetMapping("/competences")
    @JsonView(MyJsonView.Competence.class)
    public List<Competence> showCompetence() {
        return this.competenceService.findAll();
    }

    /**
     * Api Endpoint url Get retourne un Competences avec l'id
     * @param id
     * @return
     */
    @GetMapping("/competences/{id}")
    @JsonView(MyJsonView.Competence.class)
    public Competence getcomp(@PathVariable int id) {
        return (Competence) this.competenceService.findById(id);
    }

    /**
     * Api Endpoint url PUT pour Ajouter un Competences
     * @param competences
     * @return
     */
    @PutMapping("/addcomp")
    @JsonView(MyJsonView.Competence.class)
    public Competence addcomp(@RequestBody Competence competences) {
        return this.competenceService.save(competences);
    }


    /**
     * Api Endpoint url DELETE pour supprimer une Competence
     * @param id
     */
    @DeleteMapping("/delcomp/{id}")
    @JsonView(MyJsonView.Competence.class)
    public void delete(@PathVariable int id) {
        this.competenceService.delete(id);
    }
}
