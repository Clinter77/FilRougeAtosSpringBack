package com.atos.project.security.services;

import com.atos.project.model.Experience;
import com.atos.project.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    
    @Autowired
    ExperienceRepository experienceRepository;

    /*List Tous les experience*/
    public List<Experience> getAll() {
        return this.experienceRepository.findAll();
    }

    public Experience addExperience(Experience experience) {
        return this.experienceRepository.save(experience);
    }

    public Experience findById(Integer id) {
        return this.experienceRepository.findById(id).get();
    }

    public List<Experience> findAll() {
        return this.experienceRepository.findAll();
    }

    public Experience save(Experience experience) {
        return this.experienceRepository.save(experience);
    }

    public void delete(Integer id) {
        this.experienceRepository.deleteById(id);
    }
}
