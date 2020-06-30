package com.atos.project.repository;

import com.atos.project.model.BesoinCompetence;
import com.atos.project.model.CollaborateurCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BesoinCompetenceRepo extends JpaRepository<BesoinCompetence, Integer> {
}
