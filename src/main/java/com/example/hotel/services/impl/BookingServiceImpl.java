package com.example.hotel.services.impl;

import com.example.hotel.model.Booking;
import com.example.hotel.model.BookingPaidService;
import com.example.hotel.model.PaidService;
import com.example.hotel.model.RoomPrice;
import com.example.hotel.repos.BookingRepository;
import com.example.hotel.repos.RegionRepository;
import com.example.hotel.services.BookingService;
import com.example.hotel.services.RoomPriceService;
import com.example.hotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;
    @Autowired
    private RoomPriceService roomPriceService;
    @Autowired
    private RegionRepository regionRepository;

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
        else throw new RuntimeException("Booking NOT found for id : " + id);
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
        return this.repository.findAllByStatusesOrderByBookingTimeDesc(statuses);
    }

    @Override
    public List<Booking> getNewBookings() {
        List<String> statuses = new ArrayList<>();
        statuses.add("Подтверждено");
        statuses.add("Требуется предоплата");
        return this.repository.findAllByStatusesOrderByBookingTimeDesc(statuses);
    }

    @Override
    public List<Booking> getAllBookingOrderByBookingTimeDesc() {
        return this.repository.findAllOrderByBookingTimeDesc();
    }

    @Override
    public double countHotelPrice(Booking booking) {
        double cost = 0.0;

        RoomPrice roomPrice = roomPriceService.getActualRoomPrice(booking.getRoomType());
        // Проживание в течение заявленных дней в забронированных номерах
        cost = roomPrice.getPrice() * booking.getRoomsAmount() * this.countOccupationPeriod(booking);

        // Прибавление стоимости доп. кровати, если указана
        if (booking.getExtraBed() != null) {
            cost += booking.getExtraBed().getPrice();
        }
        return cost;
    }

    @Override
    public double countPrepaymentCost(Booking booking) {
        // Предоплата = стоимость одного дня проживания
        double cost = roomPriceService.getActualRoomPrice(booking.getRoomType()).getPrice() * booking.getRoomsAmount();
        return cost;
    }

    @Override
    public double countTotalCost(Booking booking) {
        // Полная стоимость проживания = общ ст-ть проживания в номере/ах - преодплата + общ ст-ть платных услуг
        double cost = booking.getTotalCost() - this.countPrepaymentCost(booking);
        List<BookingPaidService> paidServices = booking.getBookingPaidServiceList();
        if (paidServices != null) {
            for (BookingPaidService ps : paidServices) {
                cost += ps.getPaidService().getPrice();
            }
        }
        return cost;
    }

    @Override
    public long countOccupationPeriod(Booking booking) {
        long diffInMillisecond = booking.getCheckOutDate().getTime() - booking.getCheckInDate().getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillisecond, TimeUnit.MILLISECONDS);
        return diffInDays;
    }
}
