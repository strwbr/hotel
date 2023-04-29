package com.example.hotel.services.impl;

import com.example.hotel.model.RoomTypeBedType;
import com.example.hotel.repos.RoomTypeBedTypeRepository;
import com.example.hotel.services.RoomTypeBedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeBedTypeServiceImpl implements RoomTypeBedTypeService {

    @Autowired
    private RoomTypeBedTypeRepository repository;

    @Override
    public List<RoomTypeBedType> getAllRoomTypeBedTypes() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomTypeBedType(RoomTypeBedType roomTypeBedType) {
        this.repository.save(roomTypeBedType);
    }

    @Override
    public RoomTypeBedType getRoomTypeBedTypeById(long id) {
        Optional<RoomTypeBedType> optional = repository.findById(id);
        RoomTypeBedType roomTypeBedType = null;
        if (optional.isPresent())
            roomTypeBedType = optional.get();
        else throw new RuntimeException("RoomTypeBedType NOT found for id : \" + id");
        return roomTypeBedType;
    }

    @Override
    public void deleteRoomTypeBedTypeById(long id) {
        this.repository.deleteById(id);
    }
}
