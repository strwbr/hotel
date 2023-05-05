package com.example.hotel.services.impl;

import com.example.hotel.model.ExtraBed;
import com.example.hotel.model.OccupiedRoom;
import com.example.hotel.repos.OccupiedRoomRepository;
import com.example.hotel.services.OccupiedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class OccupiedRoomServiceImpl implements OccupiedRoomService {

    @Autowired
    private OccupiedRoomRepository repository;

    @Override
    public List<OccupiedRoom> getAllOccupiedRooms() {
        return this.repository.findAll();
    }

    @Override
    public void saveOccupiedRoom(OccupiedRoom occupiedRoom) {
        this.repository.save(occupiedRoom);
    }

    @Override
    public OccupiedRoom getOccupiedRoomById(long id) {
        Optional<OccupiedRoom> optional = repository.findById(id);
        OccupiedRoom occupiedRoom = null;
        if (optional.isPresent())
            occupiedRoom = optional.get();
        else throw new RuntimeException("OccupiedRoom NOT found for id : \" + id");
        return occupiedRoom;
    }

    @Override
    public void deleteOccupiedRoomById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<OccupiedRoom> getAllOccupiedRoomsByClientId(long id) {
        return this.repository.findAllOccupiedRoomsByClientId(id);
    }

    @Override
    public boolean isEarlyCheckIn(OccupiedRoom occupiedRoom) {
        return isEarlyCheckIn(occupiedRoom.getArrival().getRealArrivalTime());
    }

    @Override
    public boolean isLateCheckOut(OccupiedRoom occupiedRoom) {
        return isLateCheckOut(occupiedRoom.getDeparture().getRealDepartureTime());
    }

    private boolean isEarlyCheckIn(LocalTime realTime) {
        LocalTime checkInTime = LocalTime.of(12, 0);
        return realTime.isBefore(checkInTime);
    }

    private boolean isLateCheckOut(LocalTime realTime) {
        LocalTime checkOutTime = LocalTime.of(12, 0);
        return realTime.isAfter(checkOutTime);
    }
}
