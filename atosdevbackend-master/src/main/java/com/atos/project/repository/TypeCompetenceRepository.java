package com.atos.project.repository;

import com.atos.project.model.TypeCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCompetenceRepository extends JpaRepository<TypeCompetence, Integer> {
}
