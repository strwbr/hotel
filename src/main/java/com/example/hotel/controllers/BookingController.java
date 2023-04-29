package com.example.hotel.controllers;

import com.example.hotel.model.*;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private PaidServiceService paidServiceService;
    @Autowired
    private BedTypeService bedTypeService;
    @Autowired
    private BookingStatusService bookingStatusService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Booking> bookings = bookingService.getNewBookings();
        model.addAttribute("bookings", bookings);
        return "bookings-list";
    }

    @GetMapping("/info/{id}")
    private String bookingInfo(@PathVariable(value = "id") long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "booking-info";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("clients", clientService.getAllClients());
        // TODO выводить ТОЛЬКО типы номеров, у к-ых ЕСТЬ актуальная цена
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
        model.addAttribute("paidServices", paidServiceService.getAllPaidServices());
        model.addAttribute("bedTypes", bedTypeService.getAllBedTypes());
        return "booking-add";
    }

    @PostMapping("/add")
    private String addBooking(@ModelAttribute("booking") Booking booking,
                              @RequestParam(value = "selectedPaidServices", required = false) List<Long> selectedPaidServices,
                              @RequestParam(value = "selectedExtraBed", required = false) Long selectedExtraBed,
                              RedirectAttributes redirectAttributes) {

        if (selectedPaidServices != null) {
            List<BookingPaidService> bookingPaidServiceList = new ArrayList<>();
            for (int i = 0; i < selectedPaidServices.size(); i++) {
                Long id = selectedPaidServices.get(i);
                PaidService paidService = paidServiceService.getPaidServiceById(id);
                if (paidService != null) {
                    BookingPaidService temp = new BookingPaidService(
                            booking, paidService
                    );
                    bookingPaidServiceList.add(temp);
                }
            }
            booking.setBookingPaidServiceList(bookingPaidServiceList);
        }

        if (selectedExtraBed != null) {
            ExtraBed extraBed = new ExtraBed(
                    bedTypeService.getBedTypeById(selectedExtraBed), booking
            );
            booking.setExtraBed(extraBed);
        }

        booking.setTotalCost(bookingService.countHotelPrice(booking));
        booking.setBookingTime(new Date());
        booking.setBookingStatus(bookingStatusService.getBookingStatusForNewBooking());

        // TODO сюда добавление OccupiedRoom - автоматическое присваивание номера (из числа свободных в нужную дату)

        bookingService.saveBooking(booking);
        redirectAttributes.addAttribute("id", booking.getId());
        return "redirect:/booking/prepayment";
    }


}
