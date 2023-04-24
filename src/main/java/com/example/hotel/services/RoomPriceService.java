package com.example.hotel.services;

import com.example.hotel.model.RoomPrice;
import com.example.hotel.model.RoomType;

import java.util.List;

public interface RoomPriceService {
    List<RoomPrice> getAllRoomPrices();
    void saveRoomPrice(RoomPrice roomPrice);
    RoomPrice getRoomPriceById(long id);
    void deleteRoomPriceById(long id);

    RoomPrice getActualRoomPrice(RoomType roomType);
}
