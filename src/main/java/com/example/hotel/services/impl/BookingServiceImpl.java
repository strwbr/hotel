package com.example.hotel.services.impl;

import com.example.hotel.model.Booking;
import com.example.hotel.repos.BookingRepository;
import com.example.hotel.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository repository;

    @Override
    public List<Booking> getAllBookings() {
        return this.repository.findAll();
    }

    @Override
    public void saveBooking(Booking booking) {
        this.repository.save(booking);
    }

    @Override
    public Booking getBookingById(long id) {
        Optional<Booking> optional = repository.findById(id);
        Booking booking = null;
        if (optional.isPresent())
            booking = optional.get();
        else throw new RuntimeException("Booking NOT found for id : \" + id");
        return booking;
    }

    @Override
    public void deleteBookingById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Booking> getCompletedOrCancelledBookings() {
        List<String> statuses = new ArrayList<>();
        statuses.add("Отменено");
        statuses.add("Завершено");
        return this.repository.findBookingsByStatuses(statuses);
    }
}
