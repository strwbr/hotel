package com.example.hotel.controllers;

import com.example.hotel.model.BedType;
import com.example.hotel.model.RoomType;
import com.example.hotel.services.impl.BedTypeServiceImpl;
import com.example.hotel.services.impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class RoomTypeController {
    @Autowired
    private RoomTypeServiceImpl roomTypeService;
    @Autowired
    private BedTypeServiceImpl bedTypeService;

    @GetMapping("/room_type")
    private String viewList(Model model) {
        Iterable<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("roomTypesList",
                roomTypes);
        model.addAttribute("count", 0);
        return "room-types-list";
    }

    @GetMapping("/room_type/add")
    private String showNewRoomTypeForm(Model model) {
        Collection<String> allBedTypesName = bedTypeService.getAllBedTypesName();
        model.addAttribute("bedTypeNames", allBedTypesName);
        return "room-type-add";
    }

    @PostMapping("/room_type/add")
    private String addRoomType(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam String baseCapacity,
                               @RequestParam String maxCapacity,
                               Model model) {
        RoomType roomType = new RoomType();
        roomType.setName(name);
        roomType.setDescription(description);
        roomType.setBaseCapacity(Byte.parseByte(baseCapacity));
        roomType.setMaxCapacity(Byte.parseByte(maxCapacity));

        roomTypeService.saveRoomType(roomType);
        return "redirect:/room_type";
    }
}
