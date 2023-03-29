package com.example.hotel.controllers;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.services.impl.AdditionalServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdditionalServiceController {
    @Autowired
    private AdditionalServiceServiceImpl additionalServiceService;

    @GetMapping("/additional_service")
    private String viewList(Model model) {
        model.addAttribute("listAdditionalService",
                additionalServiceService.getAllAdditionalServices());
        return "additional-services-list";
    }

    @GetMapping("/additional_service/add")
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
    }
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
