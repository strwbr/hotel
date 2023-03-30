package com.example.hotel.services;

import com.example.hotel.model.RoomTypeAdditionalService;

import java.util.List;

public interface RoomTypeAdditionalServiceService {
    List<RoomTypeAdditionalService> getAllRoomTypeAdditionalServices();
    void saveRoomTypeAdditionalService(RoomTypeAdditionalService roomTypeAdditionalService);
    RoomTypeAdditionalService getRoomTypeAdditionalServiceById(long id);
    void deleteRoomTypeAdditionalServiceById(long id);
}
