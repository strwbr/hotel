package com.example.hotel.services.impl;

import com.example.hotel.model.RoomStatus;
import com.example.hotel.repos.RoomStatusRepository;
import com.example.hotel.services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {

    @Autowired
    private RoomStatusRepository repository;

    @Override
    public List<RoomStatus> getAllRoomStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoomStatus(RoomStatus roomStatus) {
        this.repository.save(roomStatus);
    }

    @Override
    public RoomStatus getRoomStatusById(long id) {
        return null;
    }

    @Override
    public void deleteRoomStatusById(long id) {
        this.repository.deleteById(id);
    }
}
