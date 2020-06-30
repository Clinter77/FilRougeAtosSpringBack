package com.atos.project.controllers;

import com.atos.project.model.TypeCompetence;
import com.atos.project.security.services.TypeCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TypeCompController {

    TypeCompetenceService typeCompetenceService;

    @Autowired
    public TypeCompController(final TypeCompetenceService typeCompetenceService ) {this.typeCompetenceService = typeCompetenceService;}

    /*******************************************************
     *                      List of TypeCompetenceService
     *******************************************************/
    @GetMapping("/tcp")
    public List<TypeCompetence> showTypeCompetenceService() {
        return this.typeCompetenceService.findAll();
    }

    @GetMapping("/tcp/{id}")
    public TypeCompetence getEvt(@PathVariable int id) {
        return (TypeCompetence) this.typeCompetenceService.findById(id);
    }


    /*******************************************************
     *                     Add TypeCompetenceService
     *******************************************************/
    @PutMapping("/addtcp")
    public TypeCompetence addtcp(@RequestBody TypeCompetence typeCompetence) {
        return this.typeCompetenceService.save(typeCompetence);
    }

    /******************************************************
     *                      Delete TypeCompetenceService
     *******************************************************/

    @DeleteMapping("/tcps/{id}")
    public void delete(@PathVariable int id) {
        this.typeCompetenceService.delete(id);
    }
}
