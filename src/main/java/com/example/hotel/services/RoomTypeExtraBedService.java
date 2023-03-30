package com.example.hotel.services;

import com.example.hotel.model.RoomTypeExtraBed;

import java.util.List;

public interface RoomTypeExtraBedService {
    List<RoomTypeExtraBed> getAllRoomTypeExtraBeds();
    void saveRoomTypeExtraBed(RoomTypeExtraBed roomTypeExtraBed);
    RoomTypeExtraBed getRoomTypeExtraBedById(long id);
    void deleteRoomTypeExtraBedById(long id);
}
