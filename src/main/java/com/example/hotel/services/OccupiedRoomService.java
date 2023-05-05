package com.example.hotel.services;

import com.example.hotel.model.OccupiedRoom;

import java.util.List;

public interface OccupiedRoomService {
    List<OccupiedRoom> getAllOccupiedRooms();
    void saveOccupiedRoom(OccupiedRoom occupiedRoom);
    OccupiedRoom getOccupiedRoomById(long id);
    void deleteOccupiedRoomById(long id);

    List<OccupiedRoom> getAllOccupiedRoomsByClientId(long id);

    boolean isEarlyCheckIn(OccupiedRoom occupiedRoom);
    boolean isLateCheckOut(OccupiedRoom occupiedRoom);

}
