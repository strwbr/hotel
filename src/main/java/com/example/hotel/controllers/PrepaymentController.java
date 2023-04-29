package com.example.hotel.controllers;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Payment;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/payment")
public class PrepaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingStatusService bookingStatusService;
    @Autowired
    private PaymentPurposeService paymentPurposeService;
    @Autowired
    private PaymentTypeService paymentTypeService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PaymentStatusService paymentStatusService;

    @GetMapping("/booking/prepayment")
    private String viewAddForm(@RequestParam("id") Long bookingId, Model model) {
        Booking booking = bookingService.getBookingById(bookingId);

        double cost = bookingService.countPrepaymentCost(booking);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setPurpose(paymentPurposeService.getPaymentPurposeForPrepayment());
        payment.setAmount(cost);

        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(payment);
        booking.setPaymentList(paymentList);
        bookingService.saveBooking(booking);

        model.addAttribute("payment", payment);
        model.addAttribute("booking", booking);
        model.addAttribute("cost", cost);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("paymentTypes", paymentTypeService.getAllPaymentTypes());
        return "prepayment";
    }

    @PostMapping("/booking/prepayment")
    private String addPayment(@ModelAttribute("payment") Payment payment,
                              @RequestParam("bookingId") Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);

        Payment prepayment = paymentService.getPaymentByBookingIdAndPurposeName(bookingId, "Предоплата"); //booking.getPaymentList().get(0); // По цели "Предоплата"
        prepayment.setPaymentDate(new Date());
        prepayment.setEmployee(payment.getEmployee());
        prepayment.setPaymentType(payment.getPaymentType());
        prepayment.setPaymentStatus(paymentStatusService.getSuccessfulStatus());

        List<Payment> paymentList = booking.getPaymentList();
        paymentList.add(0, prepayment);
        booking.setPaymentList(paymentList);
        booking.setBookingStatus(bookingStatusService.getBookingStatusByName("Подтверждено"));
        bookingService.saveBooking(booking);

//        paymentService.savePayment(temp);
        return "redirect:/booking";
    }
}
