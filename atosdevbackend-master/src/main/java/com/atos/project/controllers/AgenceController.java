package com.atos.project.controllers;

/**
 * @RestController : déclaration de cette Classe comme étant contrôleur de Web Services - et sans utilisation de système de Template
 * @CrossOrigin : pour autoriser des requêtes provenant d'autres serveurs (les ressources de l'API se situent sur plusieurs Serveurs)
 *                requêtes multi-domaines - partage de ressources d'origines croisées (CORS)
 * @Autowired : le paramètre du constructeur est une injection de dépendances
 * @GetMapping : le mappage url via la méthode Get (la méthode Get est bien plus limitée dans la quantité de données transmissibles que la méthode Put)
 * @JsonView : pour pouvoir filtrer les résultats (les vues JsonView) qui apparaîtront dans les résultats de requêtes (et éviter ainsi les doublons - les erreurs de redondance cyclique)
 * @PutMapping : pour permettre l'insertion des Data via mapping
 * @DeleteMapping : pour permettre la suppression de Datas via mapping
 * 
 */

import com.atos.project.model.Agence;
import com.atos.project.repository.AgenceRepository;
import com.atos.project.security.services.AgenceService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AgenceController {
    
    AgenceService agenceService;

    @Autowired
    public AgenceController(final AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    /**
     * Api Endpoint GET List of Agence
     * @return
     */
    @GetMapping("/agence")
    @JsonView(MyJsonView.SiteClient.class)
    public List<Agence> showAgence() {
        return this.agenceService.findAll();
    }

    /**
     * Api EndPoint GET Agence par son attribut id
     * @param id
     * @return
     */
    @GetMapping("/agence/{id}")
    @JsonView(MyJsonView.SiteClient.class)
    public Agence getAgence(@PathVariable int id) {
        return (Agence) this.agenceService.findById(id);
    }


    /**
     * Api Endpoit pour Ajouter Un Agence
     * @param id
     * @return
     */
    @PutMapping("/addAgence")
    @JsonView(MyJsonView.SiteClient.class)
    public Agence putAgence(@RequestBody Agence id) { return this.agenceService.save(id);   }


    /**
     * Api Endpoit pour faire un deletde d'Un Agence par son attribut id
     * @param id
     */
    @DeleteMapping("/agence/{id}")
    @JsonView(MyJsonView.SiteClient.class)
    public void delete(@PathVariable int id) {
        this.agenceService.delete(id);
    }
}
