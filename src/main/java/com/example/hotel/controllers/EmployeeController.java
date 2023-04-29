package com.example.hotel.controllers;

import com.example.hotel.model.Address;
import com.example.hotel.model.Employee;
import com.example.hotel.model.StreetType;
import com.example.hotel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private JobPositionService jobPositionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private StreetTypeService streetTypeService;

    @GetMapping
    private String viewList(Model model) {
        Iterable<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees-list";
    }

    @GetMapping("/info/{id}")
    private String employeeInfo(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("residenceAddress",
                addressService.getFullAddressString(employee.getResidenceAddress().getId()));
        model.addAttribute("registeredAddress",
                addressService.getFullAddressString(employee.getRegisteredAddress().getId()));

        return "employees-info";
    }
}
