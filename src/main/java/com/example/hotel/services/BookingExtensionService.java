package com.example.hotel.services;

import com.example.hotel.model.BookingExtension;

import java.util.List;

public interface BookingExtensionService {
    List<BookingExtension> getAllBookingExtensions();
    void saveBookingExtension(BookingExtension bookingExtension);
    BookingExtension getBookingExtensionById(long id);
    void deleteBookingExtensionById(long id);
}
