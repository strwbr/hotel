package com.example.hotel.services;

import com.example.hotel.model.RoomPriceStatus;

import java.util.List;

public interface RoomPriceStatusService {
    List<RoomPriceStatus> getAllRoomPriceStatuses();
    void saveRoomPriceStatus(RoomPriceStatus roomPriceStatus);
    RoomPriceStatus getRoomPriceStatusById(long id);
    void deleteRoomPriceStatusById(long id);

    RoomPriceStatus getRoomPriceStatusByName(String name);
    RoomPriceStatus getActualStatus(); // Актуально
    RoomPriceStatus getAwaitingStatus(); // В ожидании
    RoomPriceStatus getExpiredStatus(); // Истек
}
