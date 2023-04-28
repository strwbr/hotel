package com.example.hotel.controllers;

import com.example.hotel.model.Department;
import com.example.hotel.services.DepartmentService;
import com.example.hotel.services.DepartmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentStatusService departmentStatusService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments-list";
    }

    @GetMapping("/add")
    private String viewAddForm(Model model) {
        model.addAttribute("department", new Department());
        return "department-add";
    }

    @PostMapping("/add")
    private String addDepartment(@ModelAttribute("department") Department department) {
        department.setDepartmentStatus(departmentStatusService.getDepartmentStatusByName("Работающий"));
        departmentService.saveDepartment(department);
        return "redirect:/department";
    }
}
