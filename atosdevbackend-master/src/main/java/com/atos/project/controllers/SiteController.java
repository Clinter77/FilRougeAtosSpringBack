package com.atos.project.controllers;

import com.atos.project.model.Site;
import com.atos.project.security.services.SiteService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SiteController {
    
    SiteService siteService;

    public SiteController(final SiteService siteService) {
        this.siteService = siteService;
    }

    /*******************************************************
     *                      List of Site
     *******************************************************/
    @GetMapping("/site")
    @JsonView(MyJsonView.SiteClient.class)
    public List<Site> showSite() {
        return this.siteService.findAll();
    }

    @GetMapping("/site/{id}")
    @JsonView(MyJsonView.SiteClient.class)
    public Site getsite(@PathVariable int id) {
        return (Site) this.siteService.findById(id);
    }


    /*******************************************************
     *                     Add Site
     *******************************************************/
    @PutMapping("/addSit")
    @JsonView(MyJsonView.SiteClient.class)
    public Site addSite(@RequestBody Site sites) {
        return this.siteService.save(sites);
    }

    /******************************************************
     *                      Delete Site
     *******************************************************/

    @DeleteMapping("/delSit/{id}")
    @JsonView(MyJsonView.SiteClient.class)
    public void delete(@PathVariable int id) {
        this.siteService.delete(id);
    }
}

