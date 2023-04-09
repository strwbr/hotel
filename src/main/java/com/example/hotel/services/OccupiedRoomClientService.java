package com.example.hotel.services;

import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.model.OccupiedRoomClient;

import java.util.List;

public interface OccupiedRoomClientService {
    List<OccupiedRoomClient> getAllOccupiedRoomClient();
    void saveOccupiedRoomClient(OccupiedRoomClient occupiedRoomClient);
    OccupiedRoomClient getOccupiedRoomClientById(long id);
    void deleteOccupiedRoomClientById(long id);
}
