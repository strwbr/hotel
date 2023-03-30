package com.example.hotel.services.impl;

import com.example.hotel.model.Employee;
import com.example.hotel.repos.EmployeeRepository;
import com.example.hotel.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.repository.deleteById(id);
    }
}
