package com.example.hotel.services.impl;

import com.example.hotel.model.ClientStatus;
import com.example.hotel.repos.ClientStatusRepository;
import com.example.hotel.services.ClientStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientStatusServiceImpl implements ClientStatusService {

    @Autowired
    private ClientStatusRepository repository;

    @Override
    public List<ClientStatus> getAllClientStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveClientStatus(ClientStatus clientStatus) {
        this.repository.save(clientStatus);
    }

    @Override
    public ClientStatus getClientStatusById(long id) {
        return null;
    }

    @Override
    public void deleteClientStatusById(long id) {
        this.repository.deleteById(id);
    }
}
