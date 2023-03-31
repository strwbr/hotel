package com.example.hotel.services.impl;

import com.example.hotel.model.DocumentType;
import com.example.hotel.model.Employee;
import com.example.hotel.repos.EmployeeRepository;
import com.example.hotel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return this.repository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = repository.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else throw new RuntimeException("Employee NOT found for id : \" + id");
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.repository.deleteById(id);
    }
}
