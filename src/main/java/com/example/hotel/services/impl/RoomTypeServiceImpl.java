package com.example.hotel.services.impl;

import com.example.hotel.model.RoomType;
import com.example.hotel.repos.RoomPriceStatusRepository;
import com.example.hotel.repos.RoomTypeRepository;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository repository;
    @Autowired
    private RoomPriceStatusRepository roomPriceStatusRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomType(RoomType roomType) {
        this.repository.save(roomType);
    }

    @Override
    public RoomType getRoomTypeById(long id) {
        Optional<RoomType> optional = repository.findById(id);
        RoomType roomType = null;
        if (optional.isPresent())
            roomType = optional.get();
        else throw new RuntimeException("RoomType NOT found for id : \" + id");
        return roomType;
    }

    @Override
    public void deleteRoomTypeById(long id) {
        this.repository.deleteById(id);
    }
}
