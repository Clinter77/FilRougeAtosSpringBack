package com.atos.project.security.services;

import com.atos.project.model.StatutProposition;
import com.atos.project.model.StatutProposition;
import com.atos.project.repository.StatutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatutPropService {
    
    @Autowired
    StatutRepo statutRepo;
    
    //liste Propropsition 
    public List<StatutProposition> getAll() {
        return this.statutRepo.findAll();
    }

    public StatutProposition addStatutProposition(StatutProposition Statut) {
        return this.statutRepo.save(Statut);
    }

    public StatutProposition findById(Integer id) {
        return this.statutRepo.findById(id).get();
    }

    public List<StatutProposition> findAll() {
        return this.statutRepo.findAll();
    }

    public StatutProposition save(StatutProposition Statut) {
        return this.statutRepo.save(Statut);
    }

    public void delete(Integer id) {
        this.statutRepo.deleteById(id);
    }
}
