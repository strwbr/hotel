package com.example.hotel.services.impl;

import com.example.hotel.model.RoomTypeRoomEquipment;
import com.example.hotel.repos.RoomTypeRoomEquipmentRepository;
import com.example.hotel.services.RoomTypeRoomEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeRoomEquipmentServiceImpl implements RoomTypeRoomEquipmentService {

    @Autowired
    private RoomTypeRoomEquipmentRepository repository;

    @Override
    public List<RoomTypeRoomEquipment> getAllRoomTypeRoomEquipments() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomTypeRoomEquipment(RoomTypeRoomEquipment roomTypeRoomEquipment) {
        this.repository.save(roomTypeRoomEquipment);
    }

    @Override
    public RoomTypeRoomEquipment getRoomTypeRoomEquipmentById(long id) {
        Optional<RoomTypeRoomEquipment> optional = repository.findById(id);
        RoomTypeRoomEquipment roomTypeRoomEquipment = null;
        if (optional.isPresent())
            roomTypeRoomEquipment = optional.get();
        else throw new RuntimeException("RoomTypeRoomEquipment NOT found for id : \" + id");
        return roomTypeRoomEquipment;
    }

    @Override
    public void deleteRoomTypeRoomEquipmentById(long id) {
        this.repository.deleteById(id);
    }
}
