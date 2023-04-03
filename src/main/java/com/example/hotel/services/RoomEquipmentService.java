package com.example.hotel.services;

import com.example.hotel.model.RoomEquipment;

import java.util.Collection;
import java.util.List;

public interface RoomEquipmentService {
    List<RoomEquipment> getAllRoomEquipments();
    void saveRoomEquipment(RoomEquipment roomEquipment);
    RoomEquipment getRoomEquipmentById(long id);
    void deleteRoomEquipmentById(long id);

    Collection<String> getAllRoomEquipmentsNames();
}
