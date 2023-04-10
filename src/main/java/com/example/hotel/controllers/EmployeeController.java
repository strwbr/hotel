package com.example.hotel.controllers;

import com.example.hotel.model.Employee;
import com.example.hotel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees-list";
    }
}
