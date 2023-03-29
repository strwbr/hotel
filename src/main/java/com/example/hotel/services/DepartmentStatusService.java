package com.example.hotel.services;

import com.example.hotel.model.DepartmentStatus;

import java.util.List;

public interface DepartmentStatusService {
    List<DepartmentStatus> getAllDepartmentStatuses();
    void saveDepartmentStatus(DepartmentStatus departmentStatus);
    DepartmentStatus getDepartmentStatusById(long id);
    void deleteDepartmentStatusById(long id);
}
