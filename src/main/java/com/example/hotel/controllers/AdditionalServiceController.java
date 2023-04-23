package com.example.hotel.controllers;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.model.AvailabilityStatus;
import com.example.hotel.services.AdditionalServiceService;
import com.example.hotel.services.AvailabilityStatusService;
import com.example.hotel.services.impl.AdditionalServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/additional_service")
public class AdditionalServiceController {

    @Autowired
    private AdditionalServiceService additionalServiceService;
    @Autowired
    private AvailabilityStatusService availabilityStatusService;

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

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("additionalService", new AdditionalService());
        model.addAttribute("availabilityStatuses", availabilityStatusService.getAllAvailabilityStatuses());
        return "additional-services-add";
    }

    @PostMapping("/add")
    private String addAdditionalService(@ModelAttribute("additionalService") AdditionalService additionalService) {

        additionalServiceService.saveAdditionalService(additionalService);
        return "redirect:/additional_service";
    }

   /* @GetMapping("/additional_service/add")
    private String showNewAdditionalServiceForm(Model model) {
        // след две строчки нужны для th:object, без него сразу return
        AdditionalService additionalService = new AdditionalService();
        model.addAttribute("additionalService", additionalService);
        return "additional-services-add";
    }

    @PostMapping("/additional_service/add")
    private String addAdditionalService(@ModelAttribute("additionalService") AdditionalService additionalService) {

        additionalServiceService.saveAdditionalService(additionalService);
        return "redirect:/additional_service";
    }*/
/*    @PostMapping("/additional_service/add")
    private String addAdditionalService(
            @RequestParam String name, @RequestParam String description, Model model
    ) {
        AdditionalService additionalService = new AdditionalService();
        additionalService.setName(name);
        additionalService.setDescription(description);
        additionalService.setRoomTypeAdditionalServiceList(null);
        additionalService.setAvailabilityStatus(null);
        additionalServiceService.saveAdditionalService(additionalService);
        return "redirect:/additional_service";
    }*/
}
