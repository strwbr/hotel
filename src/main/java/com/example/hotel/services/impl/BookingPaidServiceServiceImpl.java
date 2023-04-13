package com.example.hotel.services.impl;

import com.example.hotel.model.BookingPaidService;
import com.example.hotel.repos.BookingPaidServiceRepository;
import com.example.hotel.services.BookingPaidServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingPaidServiceServiceImpl implements BookingPaidServiceService {

    @Autowired
    private BookingPaidServiceRepository repository;

    @Override
    public List<BookingPaidService> getAllBookingPaidServices() {
        return this.repository.findAll();
    }

    @Override
    public void saveBookingPaidService(BookingPaidService bookingPaidService) {
        this.repository.save(bookingPaidService);
    }

    @Override
    public BookingPaidService getBookingPaidServiceById(long id) {
        Optional<BookingPaidService> optional = repository.findById(id);
        BookingPaidService bookingPaidService = null;
        if(optional.isPresent()) {
            bookingPaidService = optional.get();
        } else {
            throw new RuntimeException("BookingPaidService NOT found for id : " + id);
        }
        return bookingPaidService;
    }

    @Override
    public void deleteBookingPaidServiceById(long id) {
        this.repository.deleteById(id);
    }
}
