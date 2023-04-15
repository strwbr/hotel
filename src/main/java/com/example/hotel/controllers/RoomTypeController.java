package com.example.hotel.controllers;

import com.example.hotel.model.*;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/room_type")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private BedTypeService bedTypeService;
    @Autowired
    private AdditionalServiceService additionalServiceService;
    @Autowired
    private RoomEquipmentService roomEquipmentService;
    @Autowired
    private RoomTypeRoomEquipmentService roomTypeRoomEquipmentService;
    @Autowired
    private ExtraBedService extraBedService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        model.addAttribute("roomTypesList",
                roomTypes);
        model.addAttribute("count", 0);
        return "room-types-list";
    }

    @GetMapping("/info/{id}")
    private String roomTypeInfo(@PathVariable(value = "id") long id, Model model) {
        RoomType roomType = roomTypeService.getRoomTypeById(id);
        Iterable<BedType> bedTypes = bedTypeService.getAllBedTypesByRoomTypeId(id);

        model.addAttribute("roomType", roomType);
        model.addAttribute("bedTypes", bedTypes);

        return "room-type-info";
    }

    @GetMapping("/add")
    private String showNewRoomTypeForm(Model model) {
        model.addAttribute("bedTypeNames", bedTypeService.getAllBedTypes());
        model.addAttribute("additionalServiceNames", additionalServiceService.getAllAdditionalServices());
        model.addAttribute("roomEquipmentNames", roomEquipmentService.getAllRoomEquipments());
        return "room-type-add";
    }

    // TODO обработать required=false на клиенте???
    @PostMapping("/add")
    private String addRoomType(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam String baseCapacity,
                               @RequestParam(required = false) boolean extraBedToggle,
                               @RequestParam String extraBedAmount,
                               @RequestParam(required = false) List<String> selectedBedTypes,
                               @RequestParam(required = false) String selectedExtraBedType,
                               @RequestParam(required = false) List<String> selectedAdditionalServices,
                               @RequestParam(required = false) List<String> selectedRoomEquipments,
                               Model model) {
        RoomType roomType = new RoomType();
        roomType.setName(name);
        roomType.setDescription(description);
        roomType.setPrice(0); // TODO по умолчанию цена типа номера = 0

        int baseCap = Integer.parseInt(baseCapacity);
        int maxCap = baseCap;
        if (extraBedToggle) {
            maxCap = baseCap + Integer.parseInt(extraBedAmount);
            // TODO не проверено
            addExtraBedInRoomType(Long.parseLong(selectedExtraBedType), Byte.parseByte(extraBedAmount));
        }
        roomType.setBaseCapacity((byte) baseCap);
        roomType.setMaxCapacity((byte) maxCap);


        List<RoomTypeRoomEquipment> roomTypeRoomEquipmentList = new ArrayList<>();
        for (String i : selectedRoomEquipments) {
            RoomTypeRoomEquipment roomTypeRoomEquipment = new RoomTypeRoomEquipment();
            roomTypeRoomEquipment.setRoomType(roomType);
            roomTypeRoomEquipment.setRoomEquipment(roomEquipmentService.getRoomEquipmentById(Long.parseLong(i)));

            roomTypeRoomEquipmentList.add(roomTypeRoomEquipment);
        }
        roomType.setRoomTypeRoomEquipmentList(roomTypeRoomEquipmentList);
        roomTypeService.saveRoomType(roomType);

        for (RoomTypeRoomEquipment i : roomTypeRoomEquipmentList) {
            roomTypeRoomEquipmentService.saveRoomTypeRoomEquipment(i);
        }

        return "redirect:/room_type";
    }

    private void addExtraBedInRoomType(long bedTypeId, byte amount) {
        ExtraBed extraBed = new ExtraBed();
        extraBed.setPrice(100);
        extraBed.setBedType(bedTypeService.getBedTypeById(bedTypeId));
        extraBedService.saveExtraBed(extraBed);
    }
}
