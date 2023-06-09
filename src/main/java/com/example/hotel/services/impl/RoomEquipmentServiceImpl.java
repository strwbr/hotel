package com.example.hotel.services.impl;

import com.example.hotel.model.Region;
import com.example.hotel.model.RoomEquipment;
import com.example.hotel.repos.RoomEquipmentRepository;
import com.example.hotel.services.RoomEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RoomEquipmentServiceImpl implements RoomEquipmentService {

    @Autowired
    private RoomEquipmentRepository repository;

    @Override
    public List<RoomEquipment> getAllRoomEquipments() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomEquipment(RoomEquipment roomEquipment) {
        this.repository.save(roomEquipment);
    }

    @Override
    public RoomEquipment getRoomEquipmentById(long id) {
        Optional<RoomEquipment> optional = repository.findById(id);
        RoomEquipment roomEquipment = null;
        if (optional.isPresent())
            roomEquipment = optional.get();
        else throw new RuntimeException("RoomEquipment NOT found for id : \" + id");
        return roomEquipment;
    }

    @Override
    public void deleteRoomEquipmentById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Collection<String> getAllRoomEquipmentsNames() {
        return this.repository.findAllNames();
    }
}
