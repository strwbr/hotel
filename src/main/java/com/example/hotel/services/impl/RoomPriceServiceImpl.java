package com.example.hotel.services.impl;

import com.example.hotel.model.RoomEquipment;
import com.example.hotel.model.RoomPrice;
import com.example.hotel.repos.RoomPriceRepository;
import com.example.hotel.services.RoomPriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoomPriceServiceImpl implements RoomPriceService {

    @Autowired
    private RoomPriceRepository repository;

    @Override
    public List<RoomPrice> getAllRoomPrices() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomPrice(RoomPrice roomPrice) {
        this.repository.save(roomPrice);
    }

    @Override
    public RoomPrice getRoomPriceById(long id) {
        Optional<RoomPrice> optional = repository.findById(id);
        RoomPrice roomPrice = null;
        if (optional.isPresent())
            roomPrice = optional.get();
        else throw new RuntimeException("RoomPrice NOT found for id : \" + id");
        return roomPrice;
    }

    @Override
    public void deleteRoomPriceById(long id) {
        this.repository.deleteById(id);
    }
}
