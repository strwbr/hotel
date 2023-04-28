package com.example.hotel.services.impl;

import com.example.hotel.model.BookingCancellation;
import com.example.hotel.model.BookingStatus;
import com.example.hotel.repos.BookingStatusRepository;
import com.example.hotel.services.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingStatusServiceImpl implements BookingStatusService {
    @Autowired
    private BookingStatusRepository repository;

    @Override
    public List<BookingStatus> getAllBookingStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveBookingStatus(BookingStatus bookingStatus) {
        this.repository.save(bookingStatus);
    }

    @Override
    public BookingStatus getBookingStatusById(long id) {
        Optional<BookingStatus> optional = this.repository.findById(id);
        BookingStatus bookingStatus = null;
        if(optional.isPresent())
            bookingStatus = optional.get();
        else
            throw new RuntimeException("BookingStatus NOT found for id : " + id);

        return bookingStatus;
    }

    @Override
    public void deleteBookingStatusById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public BookingStatus getBookingStatusByName(String name) {
        Optional<BookingStatus> optional = this.repository.findByName(name);
        BookingStatus bookingStatus = null;
        if(optional.isPresent())
            bookingStatus = optional.get();
        else
            throw new RuntimeException("BookingStatus NOT found for name : " + name);

        return bookingStatus;
    }

    @Override
    public BookingStatus getBookingStatusForNewBooking() {
        return this.getBookingStatusByName("Требуется предоплата");
    }
}
