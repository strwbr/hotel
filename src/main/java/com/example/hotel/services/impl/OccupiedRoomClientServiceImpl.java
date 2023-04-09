package com.example.hotel.services.impl;

import com.example.hotel.model.Arrival;
import com.example.hotel.model.OccupiedRoomClient;
import com.example.hotel.repos.OccupiedRoomClientRepository;
import com.example.hotel.services.OccupiedRoomClientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OccupiedRoomClientServiceImpl implements OccupiedRoomClientService {

    @Autowired
    private OccupiedRoomClientRepository repository;

    @Override
    public List<OccupiedRoomClient> getAllOccupiedRoomClient() {
        return this.repository.findAll();
    }

    @Override
    public void saveOccupiedRoomClient(OccupiedRoomClient occupiedRoomClient) {
        this.repository.save(occupiedRoomClient);
    }

    @Override
    public OccupiedRoomClient getOccupiedRoomClientById(long id) {
        Optional<OccupiedRoomClient> optional =
                repository.findById(id);
        OccupiedRoomClient occupiedRoomClient = null;
        if (optional.isPresent())
            occupiedRoomClient = optional.get();
        else throw new RuntimeException("OccupiedRoomClient NOT found for id : " + id);
        return occupiedRoomClient;
    }

    @Override
    public void deleteOccupiedRoomClientById(long id) {
        this.repository.deleteById(id);
    }
}
