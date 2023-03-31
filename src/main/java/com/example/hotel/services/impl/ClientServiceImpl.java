package com.example.hotel.services.impl;

import com.example.hotel.model.CleaningStatus;
import com.example.hotel.model.Client;
import com.example.hotel.repos.ClientRepository;
import com.example.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getAllClients() {
        return this.repository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        this.repository.save(client);
    }

    @Override
    public Client getClientById(long id) {
        Optional<Client> optional = repository.findById(id);
        Client client = null;
        if (optional.isPresent())
            client = optional.get();
        else throw new RuntimeException("Client NOT found for id : \" + id");
        return client;
    }

    @Override
    public void deleteClientById(long id) {
        this.repository.deleteById(id);
    }
}
