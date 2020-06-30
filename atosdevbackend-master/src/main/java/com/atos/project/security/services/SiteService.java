package com.atos.project.security.services;

import com.atos.project.model.Site;
import com.atos.project.repository.SiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    
    @Autowired
    SiteRepo siteRepo;

    /*List Tous les site*/
    public List<Site> getAll() {
        return this.siteRepo.findAll();
    }

    public Site addSite(Site site) {
        return this.siteRepo.save(site);
    }

    public Site findById(Integer id) {
        return this.siteRepo.findById(id).get();
    }

    public List<Site> findAll() {
        return this.siteRepo.findAll();
    }

    public Site save(Site site) {
        return this.siteRepo.save(site);
    }

    public void delete(Integer id) {
        this.siteRepo.deleteById(id);
    }
}
