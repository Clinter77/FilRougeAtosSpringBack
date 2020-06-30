package com.atos.project.security.services;

import com.atos.project.model.Collaborateur;
import com.atos.project.model.Collaborateur;
import com.atos.project.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborateurService {
    
    @Autowired
    CollaborateurRepository collaborateurRepository;

    /*List Tous les collaborateur*/
    public List<Collaborateur> getAll() {
        return this.collaborateurRepository.findAll();
    }

    public Collaborateur addCollaborateur(Collaborateur collaborateur) {
        return this.collaborateurRepository.save(collaborateur);
    }

    public Collaborateur findById(Integer id) {
        return this.collaborateurRepository.findById(id).get();
    }

    public List<Collaborateur> findAll() {
        return this.collaborateurRepository.findAll();
    }

    public Collaborateur save(Collaborateur collaborateur) {
        return this.collaborateurRepository.save(collaborateur);
    }

    public void delete(Integer id) {
        this.collaborateurRepository.deleteById(id);
    }
    
    
}
