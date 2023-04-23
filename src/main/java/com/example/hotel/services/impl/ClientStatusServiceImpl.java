package com.example.hotel.services.impl;

import com.example.hotel.model.CleaningStatus;
import com.example.hotel.model.ClientStatus;
import com.example.hotel.repos.ClientStatusRepository;
import com.example.hotel.services.ClientStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<ClientStatus> optional = repository.findById(id);
        ClientStatus clientStatus = null;
        if (optional.isPresent())
            clientStatus = optional.get();
        else throw new RuntimeException("ClientStatus NOT found for id : \" + id");
        return clientStatus;
    }

    @Override
    public void deleteClientStatusById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public ClientStatus getClientStatusByName(String name) {
        Optional<ClientStatus> optional = repository.findByName(name);
        ClientStatus clientStatus = null;
        if (optional.isPresent())
            clientStatus = optional.get();
        else throw new RuntimeException("ClientStatus NOT found for name : " + name);
        return clientStatus;
    }

    @Override
    public ClientStatus getVipStatus() {
        return this.getClientStatusByName("VIP");
    }

    @Override
    public ClientStatus getDefaultStatus() {
        return this.getClientStatusByName("default");
    }
}
