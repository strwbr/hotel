package com.example.hotel.services.impl;

import com.example.hotel.model.RoomType;
import com.example.hotel.repos.RoomTypeRepository;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository repository;

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
        return null;
    }

    @Override
    public void deleteRoomTypeById(long id) {
        this.repository.deleteById(id);
    }
}
