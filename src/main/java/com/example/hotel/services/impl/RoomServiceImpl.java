package com.example.hotel.services.impl;

import com.example.hotel.model.Room;
import com.example.hotel.model.RoomPriceStatus;
import com.example.hotel.repos.RoomRepository;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Room> optional = repository.findById(id);
        Room room = null;
        if (optional.isPresent())
            room = optional.get();
        else throw new RuntimeException("Room NOT found for id : \" + id");
        return room;
    }

    @Override
    public void deleteRoomById(long id) {
        this.repository.deleteById(id);
    }
}
