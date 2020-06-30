package com.atos.project.security.services;

import com.atos.project.model.Collaborateur;
import com.atos.project.model.CollaborateurCompetence;
import com.atos.project.repository.CollaborateurCompetenceRepo;
import com.atos.project.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborateurCompetenceService {

    @Autowired
    CollaborateurCompetenceRepo collaborateurCompetenceRepo;

    /*List Tous les collaborateur*/
    public List<CollaborateurCompetence> getAll() {
        return this.collaborateurCompetenceRepo.findAll();
    }

    public CollaborateurCompetence addCollaborateurCompetence(CollaborateurCompetence collaborateurCompetence) {
        return this.collaborateurCompetenceRepo.save(collaborateurCompetence);
    }

    public CollaborateurCompetence findById(Integer id) {
        return this.collaborateurCompetenceRepo.findById(id).get();
    }

    public List<CollaborateurCompetence> findAll() {
        return this.collaborateurCompetenceRepo.findAll();
    }

    public CollaborateurCompetence save(CollaborateurCompetence collaborateurCompetence) {
        return this.collaborateurCompetenceRepo.save(collaborateurCompetence);
    }

    public void delete(Integer id) {
        this.collaborateurCompetenceRepo.deleteById(id);
    }
}
