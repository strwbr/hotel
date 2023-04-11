package com.example.hotel.services;

import com.example.hotel.model.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    void saveBooking(Booking booking);
    Booking getBookingById(long id);
    void deleteBookingById(long id);

    List<Booking> getCompletedOrCancelledBookings();
}
