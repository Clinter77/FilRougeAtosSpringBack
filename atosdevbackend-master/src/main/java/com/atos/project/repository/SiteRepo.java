package com.atos.project.repository;

import com.atos.project.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepo extends JpaRepository<Site, Integer> {
}
