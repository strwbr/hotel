package com.example.hotel.services;

import com.example.hotel.model.RoomStatus;

import java.util.List;

public interface RoomStatusService {
    List<RoomStatus> getAllRoomStatuses();
    void saveRoomStatus(RoomStatus roomStatus);
    RoomStatus getRoomStatusById(long id);
    void deleteRoomStatusById(long id);
}
