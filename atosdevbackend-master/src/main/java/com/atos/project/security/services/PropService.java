package com.atos.project.security.services;

import com.atos.project.model.Proposition;
import com.atos.project.repository.PropRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropService {
    
    @Autowired
    PropRepo propRepo;

    /*List Tous les proposition*/
    public List<Proposition> getAll() {
        return this.propRepo.findAll();
    }

    public Proposition addProposition(Proposition proposition) {
        return this.propRepo.save(proposition);
    }

    public Proposition findById(Integer id) {
        return this.propRepo.findById(id).get();
    }

    public List<Proposition> findAll() {
        return this.propRepo.findAll();
    }

    public Proposition save(Proposition proposition) {
        return this.propRepo.save(proposition);
    }

    public void delete(Integer id) {
        this.propRepo.deleteById(id);
    }
}
