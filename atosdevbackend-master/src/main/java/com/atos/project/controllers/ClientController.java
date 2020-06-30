package com.atos.project.controllers;

import com.atos.project.model.Client;
import com.atos.project.security.services.ClientService;
import com.atos.project.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {
    
    ClientService clientService;

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    /*******************************************************
     *                      List of Client
     *******************************************************/
    @GetMapping("/client")
    @JsonView(MyJsonView.Client.class)
    public List<Client> showClient() {
        return this.clientService.findAll();
    }

    @GetMapping("/client/{id}")
    @JsonView(MyJsonView.Client.class)
    public Client getclient(@PathVariable int id) {
        return (Client) this.clientService.findById(id);
    }


    /*******************************************************
     *                     Add Client
     *******************************************************/
    @PutMapping("/addclient")
    @JsonView(MyJsonView.Client.class)
    public Client addContact(@RequestBody Client clients) {
        return this.clientService.save(clients);
    }

    /******************************************************
     *                      Delete Client
     *******************************************************/

    @DeleteMapping("/delclient/{id}")
    @JsonView(MyJsonView.Client.class)
    public void delete(@PathVariable int id) {
        this.clientService.delete(id);
    }
}
