package com.example.hotel.services.impl;

import com.example.hotel.model.RoomStatus;
import com.example.hotel.model.RoomTypeExtraBed;
import com.example.hotel.repos.RoomTypeExtraBedRepository;
import com.example.hotel.services.RoomTypeExtraBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeExtraBedServiceImpl implements RoomTypeExtraBedService {

    @Autowired
    private RoomTypeExtraBedRepository repository;

    @Override
    public List<RoomTypeExtraBed> getAllRoomTypeExtraBeds() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomTypeExtraBed(RoomTypeExtraBed roomTypeExtraBed) {
        this.repository.save(roomTypeExtraBed);
    }

    @Override
    public RoomTypeExtraBed getRoomTypeExtraBedById(long id) {
        Optional<RoomTypeExtraBed> optional = repository.findById(id);
        RoomTypeExtraBed roomTypeExtraBed = null;
        if (optional.isPresent())
            roomTypeExtraBed = optional.get();
        else throw new RuntimeException("RoomTypeExtraBed NOT found for id : \" + id");
        return roomTypeExtraBed;
    }

    @Override
    public void deleteRoomTypeExtraBedById(long id) {
        this.repository.deleteById(id);
    }
}
