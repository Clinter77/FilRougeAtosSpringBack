package com.atos.project.controllers;


import com.atos.project.model.Proposition;
import com.atos.project.security.services.PropService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PropController {
    
    PropService propService;
    
    public PropController(final PropService propService) {
        this.propService = propService;
        
    }

    /*******************************************************
     *                      List of Proposition
     *******************************************************/
    @GetMapping("/propositions")
    @JsonView(MyJsonView.Proposition.class)
    public List<Proposition> showProposition() {
        return this.propService.findAll();
    }

    @GetMapping("/propositions/{id}")
    @JsonView(MyJsonView.Proposition.class)
    public Proposition getprop(@PathVariable int id) {
        return (Proposition) this.propService.findById(id);
    }


    /*******************************************************
     *                     Add Proposition
     *******************************************************/
    @PutMapping("/addProposition")
    @JsonView(MyJsonView.Proposition.class)
    public Proposition addprop(@RequestBody Proposition propositions) {
        return this.propService.save(propositions);
    }

    /******************************************************
     *                      Delete Proposition
     *******************************************************/

    @DeleteMapping("/propositions/{id}")
    @JsonView(MyJsonView.Proposition.class)
    public void delete(@PathVariable int id) {
        this.propService.delete(id);
    }
}
