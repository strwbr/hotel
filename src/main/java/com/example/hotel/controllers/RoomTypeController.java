package com.example.hotel.controllers;

import com.example.hotel.model.RoomType;
import com.example.hotel.services.RoomEquipmentService;
import com.example.hotel.services.impl.AdditionalServiceServiceImpl;
import com.example.hotel.services.impl.BedTypeServiceImpl;
import com.example.hotel.services.impl.RoomEquipmentServiceImpl;
import com.example.hotel.services.impl.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
@RequestMapping("/room_type")
public class RoomTypeController {
    @Autowired
    private RoomTypeServiceImpl roomTypeService;
    @Autowired
    private BedTypeServiceImpl bedTypeService;
    @Autowired
    private AdditionalServiceServiceImpl additionalServiceService;
    @Autowired
    private RoomEquipmentServiceImpl roomEquipmentService;

    @GetMapping
//    @GetMapping("/room_type")
    private String viewList(Model model) {
        Iterable<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("roomTypesList",
                roomTypes);
        model.addAttribute("count", 0);
        return "room-types-list";
    }

    @GetMapping("/add")
//    @GetMapping("/room_type/add")
    private String showNewRoomTypeForm(Model model) {
        Collection<String> allBedTypesNames = bedTypeService.getAllBedTypesNames();
        Collection<String> allAdditionalServiceNames = additionalServiceService.getAllAdditionalServiceNames();
        Collection<String> allRoomEquipmentNames = roomEquipmentService.getAllRoomEquipmentsNames();
        model.addAttribute("bedTypeNames", allBedTypesNames);
        model.addAttribute("additionalServiceNames", allAdditionalServiceNames);
        model.addAttribute("roomEquipmentNames", allRoomEquipmentNames);
        return "room-type-add";
    }

    @PostMapping("/add")
//    @PostMapping("/room_type/add")
    private String addRoomType(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam String baseCapacity,
                               @RequestParam boolean extraBedToggle,
                               @RequestParam String extraBedAmount,
                               Model model) {
        RoomType roomType = new RoomType();
        roomType.setName(name);
        roomType.setDescription(description);
        roomType.setBaseCapacity(Byte.parseByte(baseCapacity));

        if(extraBedToggle) {
            roomType.setMaxCapacity((byte) (roomType.getBaseCapacity()+Byte.parseByte(extraBedAmount)));
        } else {
            roomType.setMaxCapacity(roomType.getBaseCapacity());
        }

        roomTypeService.saveRoomType(roomType);
        return "redirect:/room_type";
    }
}
