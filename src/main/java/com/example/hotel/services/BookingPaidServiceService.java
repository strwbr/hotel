package com.example.hotel.services;

import com.example.hotel.model.BookingPaidService;

import java.util.List;

public interface BookingPaidServiceService {
    List<BookingPaidService> getAllBookingPaidServices();
    void saveBookingPaidService(BookingPaidService bookingPaidService);
    BookingPaidService getBookingPaidServiceById(long id);
    void deleteBookingPaidServiceById(long id);
}
