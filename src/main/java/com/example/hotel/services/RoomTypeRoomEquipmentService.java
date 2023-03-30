package com.example.hotel.services;

import com.example.hotel.model.RoomTypeRoomEquipment;

import java.util.List;

public interface RoomTypeRoomEquipmentService {
    List<RoomTypeRoomEquipment> getAllRoomTypeRoomEquipments();
    void saveRoomTypeRoomEquipment(RoomTypeRoomEquipment roomTypeRoomEquipment);
    RoomTypeRoomEquipment getRoomTypeRoomEquipmentById(long id);
    void deleteRoomTypeRoomEquipmentById(long id);
}
