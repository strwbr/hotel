package com.example.hotel.services.impl;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.model.RoomPriceStatus;
import com.example.hotel.repos.BookingRepository;
import com.example.hotel.repos.RoomRepository;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Room> getAllRooms() {
        return this.repository.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        this.repository.save(room);
    }

    @Override
    public Room getRoomById(long id) {
        Optional<Room> optional = repository.findById(id);
        Room room = null;
        if (optional.isPresent())
            room = optional.get();
        else throw new RuntimeException("Room NOT found for id : \" + id");
        return room;
    }

    @Override
    public void deleteRoomById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Room> getAllRoomsByRoomTypeId(long roomTypeId) {
        return this.repository.findAllByRoomTypeId(roomTypeId);
    }

    @Override
    public List<Room> getAvailableRoomsForBooking(Booking booking) {
        List<Long> bookingStatusesId = new ArrayList<>();
        bookingStatusesId.add(1L); // "Подтверждено"
        bookingStatusesId.add(3L); // "Требуется предоплата"
        bookingStatusesId.add(5L); // "В процессе"
        return this.repository.findAvailableRoomsByRoomTypeId(booking.getRoomType().getId(),
                booking.getCheckInDate(), booking.getCheckOutDate(), bookingStatusesId);
    }
}
