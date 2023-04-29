package com.example.hotel.services.impl;

import com.example.hotel.model.RoomTypeAdditionalService;
import com.example.hotel.repos.RoomTypeAdditionalServiceRepository;
import com.example.hotel.services.RoomTypeAdditionalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeAdditionalServiceServiceImpl implements RoomTypeAdditionalServiceService {

    @Autowired
    private RoomTypeAdditionalServiceRepository repository;

    @Override
    public List<RoomTypeAdditionalService> getAllRoomTypeAdditionalServices() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomTypeAdditionalService(RoomTypeAdditionalService roomTypeAdditionalService) {
        this.repository.save(roomTypeAdditionalService);
    }

    @Override
    public RoomTypeAdditionalService getRoomTypeAdditionalServiceById(long id) {
        Optional<RoomTypeAdditionalService> optional = repository.findById(id);
        RoomTypeAdditionalService roomTypeAdditionalService = null;
        if (optional.isPresent())
            roomTypeAdditionalService = optional.get();
        else throw new RuntimeException("RoomTypeAdditionalService NOT found for id : \" + id");
        return roomTypeAdditionalService;
    }

    @Override
    public void deleteRoomTypeAdditionalServiceById(long id) {
        this.repository.deleteById(id);
    }
}
