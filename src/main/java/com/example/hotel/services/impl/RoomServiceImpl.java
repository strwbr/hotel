package com.example.hotel.services.impl;

import com.example.hotel.model.Room;
import com.example.hotel.repos.RoomRepository;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public List<Room> getAllRooms() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        this.repository.save(room);
    }

    @Override
    public Room getRoomById(long id) {
        return null;
    }

    @Override
    public void deleteRoomById(long id) {
        this.repository.deleteById(id);
    }
}
