package com.example.hotel.services;

import com.example.hotel.model.RoomTypeBedType;

import java.util.List;

public interface RoomTypeBedTypeService {
    List<RoomTypeBedType> getAllRoomTypeBedTypes();
    void saveRoomTypeBedType(RoomTypeBedType roomTypeBedType);
    RoomTypeBedType getRoomTypeBedTypeById(long id);
    void deleteRoomTypeBedTypeById(long id);
}
