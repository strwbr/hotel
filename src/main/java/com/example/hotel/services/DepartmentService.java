package com.example.hotel.services;

import com.example.hotel.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(long id);
    void deleteDepartmentById(long id);
}
