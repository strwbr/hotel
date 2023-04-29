package com.example.hotel.controllers;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.model.AvailabilityStatus;
import com.example.hotel.model.RoomType;
import com.example.hotel.model.RoomTypeAdditionalService;
import com.example.hotel.repos.RoomTypeRepository;
import com.example.hotel.services.AdditionalServiceService;
import com.example.hotel.services.AvailabilityStatusService;
import com.example.hotel.services.RoomTypeService;
import com.example.hotel.services.impl.AdditionalServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/additional_service")
public class AdditionalServiceController {

    @Autowired
    private AdditionalServiceService additionalServiceService;
    @Autowired
    private AvailabilityStatusService availabilityStatusService;
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<AdditionalService> additionalServices = additionalServiceService.getAllAdditionalServices();
        model.addAttribute("additionalServices", additionalServices);
        return "additional-services-list";
    }

    @GetMapping("/info/{id}")
    private String additionalServiceInfo(@PathVariable(value = "id") long id, Model model) {
        AdditionalService additionalService = additionalServiceService.getAdditionalServiceById(id);
        model.addAttribute("additionalService", additionalService);
        return "additional-services-info";
    }
}
