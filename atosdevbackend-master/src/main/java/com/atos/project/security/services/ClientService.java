package com.atos.project.security.services;

import com.atos.project.model.Client;
import com.atos.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }

    public Client addClient(Client besoin) {
        return this.clientRepository.save(besoin);
    }

    public Client findById(Integer id) {
        return this.clientRepository.findById(id).get();
    }

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    public Client save(Client besoin) {
        return this.clientRepository.save(besoin);
    }

    public void delete(Integer id) {
        this.clientRepository.deleteById(id);
    }
}
