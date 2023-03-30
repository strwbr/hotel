package com.example.hotel.services.impl;

import com.example.hotel.model.RoomTypeRoomEquipment;
import com.example.hotel.repos.RoomTypeRoomEquipmentRepository;
import com.example.hotel.services.RoomTypeRoomEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteRoomTypeRoomEquipmentById(long id) {
        this.repository.deleteById(id);
    }
}
