package com.example.hotel.controllers;

import com.example.hotel.model.PaidService;
import com.example.hotel.services.AvailabilityStatusService;
import com.example.hotel.services.PaidServiceService;
import com.example.hotel.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paid_service")
public class PaidServiceController {

    @Autowired
    private PaidServiceService paidServiceService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private AvailabilityStatusService availabilityStatusService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<PaidService> paidServices = paidServiceService.getAllPaidServices();
        model.addAttribute("paidServices", paidServices);
        return "paid-services-list";
    }

    @GetMapping("/info/{id}")
    private String paidServiceInfo(@PathVariable(value = "id") long id, Model model) {
        PaidService paidService = paidServiceService.getPaidServiceById(id);
        model.addAttribute("paidService", paidService);
        return "paid-services-info";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {

        model.addAttribute("units", unitService.getAllUnits());
        model.addAttribute("availabilityStatuses", availabilityStatusService.getAllAvailabilityStatuses());

        model.addAttribute("paidService", new PaidService());
        return "paid-services-add";
    }

    @PostMapping("/add")
    private String addPaidService(@ModelAttribute("paidService") PaidService paidService) {
        paidServiceService.savePaidService(paidService);
        return "redirect:/paid_service";
    }
}
