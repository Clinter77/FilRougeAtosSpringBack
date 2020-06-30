package com.atos.project.repository;

import com.atos.project.model.StatutProposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepo extends JpaRepository<StatutProposition, Integer> {
}
