package com.example.hotel.services.impl;

import com.example.hotel.model.RoomPrice;
import com.example.hotel.model.RoomPriceStatus;
import com.example.hotel.repos.RoomPriceStatusRepository;
import com.example.hotel.services.RoomPriceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomPriceStatusServiceImpl implements RoomPriceStatusService {

    @Autowired
    private RoomPriceStatusRepository repository;

    @Override
    public List<RoomPriceStatus> getAllRoomPriceStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomPriceStatus(RoomPriceStatus roomPriceStatus) {
        this.repository.save(roomPriceStatus);
    }

    @Override
    public RoomPriceStatus getRoomPriceStatusById(long id) {
        Optional<RoomPriceStatus> optional = repository.findById(id);
        RoomPriceStatus roomPriceStatus = null;
        if (optional.isPresent())
            roomPriceStatus = optional.get();
        else throw new RuntimeException("RoomPriceStatus NOT found for id : \" + id");
        return roomPriceStatus;
    }

    @Override
    public void deleteRoomPriceStatusById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public RoomPriceStatus getRoomPriceStatusByName(String name) {
        Optional<RoomPriceStatus> optional = repository.findByName(name);
        RoomPriceStatus roomPriceStatus = null;
        if (optional.isPresent())
            roomPriceStatus = optional.get();
        else throw new RuntimeException("RoomPriceStatus NOT found for name : " + name);
        return roomPriceStatus;
    }

    @Override
    public RoomPriceStatus getActualStatus() {
        return this.getRoomPriceStatusByName("Актуально");
    }

    @Override
    public RoomPriceStatus getAwaitingStatus() {
        return this.getRoomPriceStatusByName("В ожидании");
    }

    @Override
    public RoomPriceStatus getExpiredStatus() {
        return this.getRoomPriceStatusByName("Истек");
    }
}
