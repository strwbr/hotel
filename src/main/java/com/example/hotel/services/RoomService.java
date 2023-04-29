package com.example.hotel.services;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    void saveRoom(Room room);
    Room getRoomById(long id);
    void deleteRoomById(long id);

    List<Room> getAllRoomsByRoomTypeId(long roomTypeId);
    List<Room> getAvailableRoomsForBooking(Booking booking);
}
