package com.atos.project.security.services;


import com.atos.project.model.Besoin;
import com.atos.project.repository.BesoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BesoinService {
    
    @Autowired
    BesoinRepository besoinRepository;

    /*List Tous les besoin*/
    public List<Besoin> getAll() {
        return this.besoinRepository.findAll();
    }

    public Besoin addBesoin(Besoin besoin) {
        return this.besoinRepository.save(besoin);
    }

    public Besoin findById(Integer id) {
        return this.besoinRepository.findById(id).get();
    }

    public List<Besoin> findAll() {
        return this.besoinRepository.findAll();
    }

    public Besoin save(Besoin besoin) {
        return this.besoinRepository.save(besoin);
    }

    public void delete(Integer id) {
        this.besoinRepository.deleteById(id);
    }
}
