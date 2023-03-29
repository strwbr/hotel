package com.example.hotel.services;

import com.example.hotel.model.BookingStatus;

import java.util.List;

public interface BookingStatusService {
    List<BookingStatus> getAllBookingStatuses();
    void saveBookingStatus(BookingStatus bookingStatus);
    BookingStatus getBookingStatusById(long id);
    void deleteBookingStatusById(long id);
}
