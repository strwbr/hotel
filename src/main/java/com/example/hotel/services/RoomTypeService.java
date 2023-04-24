package com.example.hotel.services;

import com.example.hotel.model.RoomType;

import java.util.List;

public interface RoomTypeService {
    List<RoomType> getAllRoomTypes();
    void saveRoomType(RoomType roomType);
    RoomType getRoomTypeById(long id);
    void deleteRoomTypeById(long id);

//    boolean setActualStatus(RoomType roomType);
}
