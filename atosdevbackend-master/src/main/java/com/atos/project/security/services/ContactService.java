package com.atos.project.security.services;

import com.atos.project.model.ContactClient;
import com.atos.project.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepo contactRepo;

    /*List Tous les Contact clients*/
    public List<ContactClient> getAll() {
        return this.contactRepo.findAll();
    }

    public ContactClient addClient(ContactClient clients) {
        return this.contactRepo.save(clients);
    }

    public ContactClient findById(Integer id) {
        return this.contactRepo.findById(id).get();
    }

    public List<ContactClient> findAll() {
        return this.contactRepo.findAll();
    }

    public ContactClient save(ContactClient clients) {
        return this.contactRepo.save(clients);
    }

    public void delete(Integer id) {
        this.contactRepo.deleteById(id);
    }
}
