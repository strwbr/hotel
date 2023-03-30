package com.example.hotel.services.impl;

import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.repos.OccupiedRoomRepository;
import com.example.hotel.services.OccupiedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteOccupiedRoomById(long id) {
        this.repository.deleteById(id);
    }
}
