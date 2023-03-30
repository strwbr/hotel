package com.example.hotel.services;

import com.example.hotel.model.RoomPrice;

import java.util.List;

public interface RoomPriceService {
    List<RoomPrice> getAllRoomPrices();
    void saveRoomPrice(RoomPrice roomPrice);
    RoomPrice getRoomPriceById(long id);
    void deleteRoomPriceById(long id);
}
