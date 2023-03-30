package com.example.hotel.services.impl;

import com.example.hotel.model.BookingStatus;
import com.example.hotel.repos.BookingStatusRepository;
import com.example.hotel.services.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteBookingStatusById(long id) {
        this.repository.deleteById(id);
    }
}
