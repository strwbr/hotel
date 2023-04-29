package com.example.hotel.controllers;

import com.example.hotel.model.Department;
import com.example.hotel.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments-list";
    }
}
