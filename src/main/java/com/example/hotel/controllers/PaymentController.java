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
public class PaymentController {

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
    private String viewPrepaymentForm(@RequestParam("id") Long bookingId, Model model) {
        Booking booking = bookingService.getBookingById(bookingId);

        double cost = bookingService.countPrepaymentCost(booking);

        Payment payment = new Payment(cost, booking,
                paymentPurposeService.getPaymentPurposeForPrepayment());
//        payment.setBooking(booking);
//        payment.setPurpose(paymentPurposeService.getPaymentPurposeForPrepayment());
//        payment.setAmount(cost);

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
    private String addPrepayment(@ModelAttribute("payment") Payment payment,
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

    @GetMapping("/booking/check-in/payment")
    private String viewCheckInPaymentForm(@RequestParam("id") Long bookingId,
                                          Model model) {
        Booking booking = bookingService.getBookingById(bookingId);
        Payment prepayment = booking.getPaymentList().get(0);
        double cost = bookingService.countCheckInCost(booking);
        Payment payment = new Payment(cost, booking,
                paymentPurposeService.getPaymentPurposeForArrival());

        List<Payment> paymentList = new ArrayList<>();
        paymentList.add(payment);
        booking.setPaymentList(paymentList);
        bookingService.saveBooking(booking);

        model.addAttribute("payment", payment);
        model.addAttribute("prepayment", prepayment);
        model.addAttribute("booking", booking);
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("paymentTypes", paymentTypeService.getAllPaymentTypes());
        return "check-in-payment";
    }

    @PostMapping("/booking/check-in/payment")
    private String addCheckInPayment(@ModelAttribute("payment") Payment payment,
                                     @RequestParam("bookingId") Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);

        Payment checkInPayment = paymentService.getPaymentByBookingIdAndPurposeName(bookingId, "При въезде");
        checkInPayment.setPaymentDate(new Date());
        checkInPayment.setEmployee(payment.getEmployee());
        checkInPayment.setPaymentType(payment.getPaymentType());
        checkInPayment.setPaymentStatus(paymentStatusService.getSuccessfulStatus());

        List<Payment> paymentList = booking.getPaymentList();
        paymentList.set(1, checkInPayment);
        booking.setPaymentList(paymentList);
        booking.setBookingStatus(bookingStatusService.getBookingStatusByName("В процессе"));
        bookingService.saveBooking(booking);

        return "redirect:/booking";
    }
}
