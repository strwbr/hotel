package com.example.hotel.services.impl;

import com.example.hotel.model.Client;
import com.example.hotel.repos.ClientRepository;
import com.example.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteClientById(long id) {
        this.repository.deleteById(id);
    }
}
