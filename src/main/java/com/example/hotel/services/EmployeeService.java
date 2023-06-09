package com.example.hotel.services;

import com.example.hotel.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);

    List<Employee> getAllOrderedEmployees();
}
