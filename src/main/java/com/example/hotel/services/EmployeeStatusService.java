package com.example.hotel.services;

import com.example.hotel.model.EmployeeStatus;

import java.util.List;

public interface EmployeeStatusService {
    List<EmployeeStatus> getAllEmployeeStatuses();
    void saveEmployeeStatus(EmployeeStatus employeeStatus);
    EmployeeStatus getEmployeeStatusById(long id);
    void deleteEmployeeStatusById(long id);
}
