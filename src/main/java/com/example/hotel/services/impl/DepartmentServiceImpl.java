package com.example.hotel.services.impl;

import com.example.hotel.model.Department;
import com.example.hotel.repos.DepartmentRepository;
import com.example.hotel.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        return this.repository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        this.repository.save(department);
    }

    @Override
    public Department getDepartmentById(long id) {
        return null;
    }

    @Override
    public void deleteDepartmentById(long id) {
        this.repository.deleteById(id);
    }
}
