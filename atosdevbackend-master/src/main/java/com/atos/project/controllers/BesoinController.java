package com.atos.project.controllers;

import com.atos.project.model.Besoin;
import com.atos.project.security.services.BesoinService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BesoinController {
    
    BesoinService besoinService;
    
    @Autowired
    public BesoinController(final BesoinService besoinService ) {this.besoinService = besoinService;}

    /**
     * Api ENDPOINT GET List Des Besoins
     * @return
     */
    @GetMapping("/besoins")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> showBesoin() {
        return this.besoinService.findAll();
    }

    /**
     * Api ENDPOINT GET List Des Besoins par son ID
     * @param id
     * @return
     */
    @GetMapping("/besoins/{id}")
    @JsonView(MyJsonView.Besoin.class)
    public Besoin getEvt(@PathVariable int id) {
        return (Besoin) this.besoinService.findById(id);
    }


    /**
     * Api ENDPOINT PUT pour Ajouter des Besoins
     * @param besoins
     * @return
     */
    @PutMapping("/addBesoin")
    @JsonView(MyJsonView.Besoin.class)
    public Besoin addUsers(@RequestBody Besoin besoins) {
        return this.besoinService.save(besoins);
    }


    /**7
     *  Api ENDPOINT DELETE  pour Supprimer des Besoins
     * @param id_bsn
     */
    @DeleteMapping("/besoins/{id_bsn}")
    @JsonView(MyJsonView.Besoin.class)
    public void delete(@PathVariable Integer id_bsn) {
        this.besoinService.delete(id_bsn);
    }
}
