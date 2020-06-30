package com.atos.project.security.services;

import com.atos.project.model.BesoinCompetence;
import com.atos.project.model.BesoinCompetence;
import com.atos.project.repository.BesoinCompetenceRepo;
import com.atos.project.repository.BesoinCompetenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BesoinCompetenceService {

    @Autowired
    BesoinCompetenceRepo besoinCompetenceRepo;

    /*List Tous les besoin*/
    public List<BesoinCompetence> getAll() {
        return this.besoinCompetenceRepo.findAll();
    }

    public BesoinCompetence addBesoinCompetence(BesoinCompetence besoinCompetence) {
        return this.besoinCompetenceRepo.save(besoinCompetence);
    }

    public BesoinCompetence findById(Integer id) {
        return this.besoinCompetenceRepo.findById(id).get();
    }

    public List<BesoinCompetence> findAll() {
        return this.besoinCompetenceRepo.findAll();
    }

    public BesoinCompetence save(BesoinCompetence besoinCompetence) {
        return this.besoinCompetenceRepo.save(besoinCompetence);
    }

    public void delete(Integer id) {
        this.besoinCompetenceRepo.deleteById(id);
    }
}
