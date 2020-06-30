package com.atos.project.security.services;

import com.atos.project.model.TypeCompetence;
import com.atos.project.repository.TypeCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCompetenceService {
    
    @Autowired
    TypeCompetenceRepository typeCompetenceRepository;


    /*List Tous les typeCompetence*/
    public List<TypeCompetence> getAll() {
        return this.typeCompetenceRepository.findAll();
    }

    public TypeCompetence addTypeCompetence(TypeCompetence typeCompetence) {
        return this.typeCompetenceRepository.save(typeCompetence);
    }

    public TypeCompetence findById(Integer id) {
        return this.typeCompetenceRepository.findById(id).get();
    }

    public List<TypeCompetence> findAll() {
        return this.typeCompetenceRepository.findAll();
    }

    public TypeCompetence save(TypeCompetence typeCompetence) {
        return this.typeCompetenceRepository.save(typeCompetence);
    }

    public void delete(Integer id) {
        this.typeCompetenceRepository.deleteById(id);
    }
}
