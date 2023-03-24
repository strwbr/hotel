package com.example.hotel.controllers;

import com.example.hotel.services.impl.AdditionalServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdditionalServiceController {
    @Autowired
    private AdditionalServiceServiceImpl additionalServiceService;
}
