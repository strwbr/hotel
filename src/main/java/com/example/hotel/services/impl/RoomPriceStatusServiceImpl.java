package com.example.hotel.services.impl;

import com.example.hotel.model.RoomPriceStatus;
import com.example.hotel.repos.RoomPriceStatusRepository;
import com.example.hotel.services.RoomPriceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteRoomPriceStatusById(long id) {
        this.repository.deleteById(id);
    }
}
