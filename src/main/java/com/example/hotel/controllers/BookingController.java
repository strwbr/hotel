package com.example.hotel.controllers;

import com.example.hotel.model.*;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RoomService roomService;
    @Autowired
    private OccupiedRoomService occupiedRoomService;
    @Autowired
    private BookingCancellationReasonService bookingCancellationReasonService;

    @GetMapping
    private String viewList(@RequestParam(value = "bookingNumber", required = false) String bookingNumber, Model model) {
        Iterable<Booking> bookings = null;
        if (bookingNumber != null) {
            bookings = bookingService.getNewBookingsById(Long.parseLong(bookingNumber));
        } else {
            bookings = bookingService.getNewBookings();
        }
        model.addAttribute("bookings", bookings);

        return "bookings-list";
    }

    @GetMapping("/{id}/cancellation")
    private String viewBookingCancellationForm(@PathVariable("id") long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("bookingCancellation", new BookingCancellation());
        model.addAttribute("booking", booking);
        model.addAttribute("reasons", bookingCancellationReasonService.getAllBookingCancellationReasons());
        return "booking-cancellation";
    }

    @PostMapping("/{id}/cancellation")
    private String cancelBooking(@ModelAttribute("bookingCancellation") BookingCancellation bookingCancellation, @PathVariable("id") long id) {
        Booking booking = bookingService.getBookingById(id);
        booking.setBookingCancellation(bookingCancellation);
        booking.setBookingStatus(bookingStatusService.getBookingStatusByName("Отменено"));
        bookingService.saveBooking(booking);
        return "redirect:/booking";
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
        model.addAttribute("clients", clientService.getAllOrderedClients());
        // TODO выводить ТОЛЬКО типы номеров, у к-ых ЕСТЬ актуальная цена
        model.addAttribute("roomTypes", roomTypeService.getAllRoomTypes());
        model.addAttribute("paidServices", paidServiceService.getAllAvailablePaidServices());
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

        // TODO проверка на null (нет свободных) и на availableRooms.size __ booking.roomsAmount
        List<OccupiedRoom> occupiedRooms = new ArrayList<>();
        for (int i = 0; i < booking.getRoomsAmount(); i++) {
            OccupiedRoom occupiedRoom = new OccupiedRoom(
                    roomService.getAvailableRoomsForBooking(booking).get(i), booking
            );
            occupiedRooms.add(occupiedRoom);
        }
        booking.setOccupiedRoomList(occupiedRooms);

        bookingService.saveBooking(booking);
        redirectAttributes.addAttribute("id", booking.getId());
        return "redirect:/booking/prepayment";
    }

    @GetMapping("/{id}/check-in")
    private String viewCheckInForm(@PathVariable(value = "id") long bookingId, Model model) {
        Booking booking = bookingService.getBookingById(bookingId);

        model.addAttribute("booking", booking);
        model.addAttribute("checkInTime", new Date());
        model.addAttribute("prepayment", booking.getPaymentList().get(0));
        model.addAttribute("capacity", roomTypeService.countCapacity(booking.getRoomType()));
        model.addAttribute("clients", clientService.getAllOrderedClients());
        model.addAttribute("occupiedRooms", booking.getOccupiedRoomList());
        model.addAttribute("clientsAmount", booking.getAdultsAmount() + booking.getChildrenAmount());
        return "check-in";
    }

    @PostMapping("/{id}/check-in")
    private String checkInClients(@PathVariable(value = "id") long bookingId,
                                  @RequestParam Map<String, String> formData,
                                  RedirectAttributes redirectAttributes) {
        Booking booking = bookingService.getBookingById(bookingId);

        for (int i = 1; i <= booking.getAdultsAmount() + booking.getChildrenAmount(); i++) {
            Long clientId = Long.valueOf(formData.get("clientId" + i));
            Long occupiedRoomId = Long.valueOf(formData.get("occupiedRoomId" + i));
            Client client = clientService.getClientById(clientId);
            OccupiedRoom occupiedRoom = occupiedRoomService.getOccupiedRoomById(occupiedRoomId);
//            Arrival arrival = new Arrival(
//                    LocalDate.now(), LocalTime.now(), occupiedRoom
//            );
//            occupiedRoom.setArrival(arrival);

            OccupiedRoomClient occupiedRoomClient = new OccupiedRoomClient(
                    client, occupiedRoom
            );
            List<OccupiedRoomClient> temp = client.getOccupiedRoomClientList();
            temp.add(occupiedRoomClient);
            client.setOccupiedRoomClientList(temp);

            clientService.saveClient(client);
//            occupiedRoomService.saveOccupiedRoom(occupiedRoom);
        }

        for (OccupiedRoom i : booking.getOccupiedRoomList()) {
            Arrival arrival = new Arrival(LocalDate.now(), LocalTime.now(), i);
            i.setArrival(arrival);
            occupiedRoomService.saveOccupiedRoom(i);
        }

        bookingService.saveBooking(booking);
        redirectAttributes.addAttribute("id", bookingId);
        return "redirect:/booking/check-in/payment";
    }

    @GetMapping("/{id}/check-out")
    private String viewCheckOutForm(@PathVariable("id") long bookingId, Model model) {
        Booking booking = bookingService.getBookingById(bookingId);

        model.addAttribute("booking", booking);
        model.addAttribute("checkOutTime", new Date());
        return "check-out";
    }

    @PostMapping("/{id}/check-out")
    private String checkOutClients(@PathVariable(value = "id") long bookingId,
                                   RedirectAttributes redirectAttributes) {
        Booking booking = bookingService.getBookingById(bookingId);

        for (OccupiedRoom i : booking.getOccupiedRoomList()) {
            Departure departure = new Departure(i, LocalDate.now(), LocalTime.now());
            i.setDeparture(departure);
            occupiedRoomService.saveOccupiedRoom(i);
        }

        redirectAttributes.addAttribute("id", bookingId);
        return "redirect:/booking/check-out/payment";
    }

}
