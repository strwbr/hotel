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
    private String viewAddForm(Model model) {
        model.addAttribute("roomType", new RoomType());
//        TODO выводить только ДОСТУПНЫЕ доп услуги
        model.addAttribute("additionalServices", additionalServiceService.getAllAdditionalServices());
        model.addAttribute("roomEquipments", roomEquipmentService.getAllRoomEquipments());
        model.addAttribute("bedTypes", bedTypeService.getAllBedTypes());
        return "room-type-add";
    }

    @PostMapping("/add")
    private String addRoomType(@ModelAttribute("roomType") RoomType roomType,
                               @RequestParam("selectedRoomEquipments") List<Long> selectedRoomEquipments,
                               @RequestParam("equipmentsAmount") List<Byte> equipmentsAmount,
                               @RequestParam("selectedBedTypes") List<Long> selectedBedTypes,
                               @RequestParam("bedTypesAmount") List<Byte> bedTypesAmount,
                               @RequestParam(value = "selectedAdditionalServices", required = false) List<Long> selectedAdditionalServices) {

        List<RoomTypeRoomEquipment> roomTypeRoomEquipmentList = new ArrayList<>();
        for (int i = 0; i < selectedRoomEquipments.size(); i++) {
            Long id = selectedRoomEquipments.get(i);
            RoomEquipment equipment = roomEquipmentService.getRoomEquipmentById(id);
            if (equipment != null) {
                RoomTypeRoomEquipment temp = new RoomTypeRoomEquipment(
                        equipmentsAmount.get(i), equipment, roomType
                );
                roomTypeRoomEquipmentList.add(temp);
            }
        }

        List<RoomTypeBedType> roomTypeBedTypeList = new ArrayList<>();
        for (int i = 0; i < selectedBedTypes.size(); i++) {
            Long id = selectedBedTypes.get(i);
            BedType bedType = bedTypeService.getBedTypeById(id);
            if (bedType != null) {
                RoomTypeBedType temp = new RoomTypeBedType(
                        bedTypesAmount.get(i), bedType, roomType
                );
                roomTypeBedTypeList.add(temp);
            }
        }

        List<RoomTypeAdditionalService> roomTypeAdditionalServiceList = new ArrayList<>();
        if (selectedAdditionalServices != null) {
            for (int i = 0; i < selectedAdditionalServices.size(); i++) {
                Long id = selectedAdditionalServices.get(i);
                AdditionalService additionalService = additionalServiceService.getAdditionalServiceById(id);
                if(additionalService != null) {
                    RoomTypeAdditionalService temp = new RoomTypeAdditionalService(
                            additionalService, roomType
                    );
                    roomTypeAdditionalServiceList.add(temp);
                }
            }
            roomType.setRoomTypeAdditionalServiceList(roomTypeAdditionalServiceList);
        }
        roomType.setRoomTypeRoomEquipmentList(roomTypeRoomEquipmentList);
        roomType.setRoomTypeBedTypeList(roomTypeBedTypeList);
        roomTypeService.saveRoomType(roomType);
        return "redirect:/room_type";
    }
}
