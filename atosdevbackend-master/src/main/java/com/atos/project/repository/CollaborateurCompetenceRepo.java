package com.atos.project.repository;

import com.atos.project.model.CollaborateurCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborateurCompetenceRepo  extends JpaRepository<CollaborateurCompetence, Integer> {
}
