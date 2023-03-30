package com.example.hotel.services.impl;

import com.example.hotel.model.EmployeeStatus;
import com.example.hotel.repos.EmployeeStatusRepository;
import com.example.hotel.services.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeStatusServiceImpl implements EmployeeStatusService {

    @Autowired
    private EmployeeStatusRepository repository;

    @Override
    public List<EmployeeStatus> getAllEmployeeStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveEmployeeStatus(EmployeeStatus employeeStatus) {
        this.repository.save(employeeStatus);
    }

    @Override
    public EmployeeStatus getEmployeeStatusById(long id) {
        return null;
    }

    @Override
    public void deleteEmployeeStatusById(long id) {
        this.repository.deleteById(id);
    }
}
