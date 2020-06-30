package com.atos.project.security.services;

import com.atos.project.model.Competence;
import com.atos.project.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    
    @Autowired
    CompetenceRepository competenceRepository;

    /*List Tous les competence*/
    public List<Competence> getAll() {
        return this.competenceRepository.findAll();
    }

    public Competence addCompetence(Competence competence) {
        return this.competenceRepository.save(competence);
    }

    public Competence findById(Integer id) {
        return this.competenceRepository.findById(id).get();
    }

    public List<Competence> findAll() {
        return this.competenceRepository.findAll();
    }

    public Competence save(Competence competence) {
        return this.competenceRepository.save(competence);
    }

    public void delete(Integer id) {
        this.competenceRepository.deleteById(id);
    }

}
