package com.atos.project.security.services;

import com.atos.project.model.Agence;
import com.atos.project.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    
    @Autowired
    AgenceRepository agenceRepository;

    public List<Agence> getAll() {
        return this.agenceRepository.findAll();
    }

    public Agence addAgence(Agence agence) {
        return this.agenceRepository.save(agence);
    }

    public Agence findById(Integer id) {
        return this.agenceRepository.findById(id).get();
    }

    public List<Agence> findAll() {
        return this.agenceRepository.findAll();
    }

    public Agence save(Agence agence) {
        return this.agenceRepository.save(agence);
    }

    public void delete(Integer id) {
        this.agenceRepository.deleteById(id);
    }
}
