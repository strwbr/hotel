package com.example.hotel.services.impl;

import com.example.hotel.model.ExtraBed;
import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.repos.OccupiedRoomRepository;
import com.example.hotel.services.OccupiedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupiedRoomServiceImpl implements OccupiedRoomService {

    @Autowired
    private OccupiedRoomRepository repository;

    @Override
    public List<OccupiedRoom> getAllOccupiedRooms() {
        return this.repository.findAll();
    }

    @Override
    public void saveOccupiedRoom(OccupiedRoom occupiedRoom) {
        this.repository.save(occupiedRoom);
    }

    @Override
    public OccupiedRoom getOccupiedRoomById(long id) {
        Optional<OccupiedRoom> optional = repository.findById(id);
        OccupiedRoom occupiedRoom = null;
        if (optional.isPresent())
            occupiedRoom = optional.get();
        else throw new RuntimeException("OccupiedRoom NOT found for id : \" + id");
        return occupiedRoom;
    }

    @Override
    public void deleteOccupiedRoomById(long id) {
        this.repository.deleteById(id);
    }
}
