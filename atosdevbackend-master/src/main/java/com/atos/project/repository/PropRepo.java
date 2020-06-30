package com.atos.project.repository;

import com.atos.project.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropRepo extends JpaRepository<Proposition, Integer> {
}
