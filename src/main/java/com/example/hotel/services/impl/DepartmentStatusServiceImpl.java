package com.example.hotel.services.impl;

import com.example.hotel.model.Department;
import com.example.hotel.model.DepartmentStatus;
import com.example.hotel.repos.DepartmentStatusRepository;
import com.example.hotel.services.DepartmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentStatusServiceImpl implements DepartmentStatusService {

    @Autowired
    private DepartmentStatusRepository repository;

    @Override
    public List<DepartmentStatus> getAllDepartmentStatuses() {
        return this.repository.findAll();
    }

    @Override
    public void saveDepartmentStatus(DepartmentStatus departmentStatus) {
        this.repository.save(departmentStatus);
    }

    @Override
    public DepartmentStatus getDepartmentStatusById(long id) {
        Optional<DepartmentStatus> optional = repository.findById(id);
        DepartmentStatus departmentStatus = null;
        if (optional.isPresent())
            departmentStatus = optional.get();
        else throw new RuntimeException("DepartmentStatus NOT found for id : " + id);
        return departmentStatus;
    }

    @Override
    public void deleteDepartmentStatusById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public DepartmentStatus getDepartmentStatusByName(String name) {
        Optional<DepartmentStatus> optional = repository.findByName(name);
        DepartmentStatus departmentStatus = null;
        if (optional.isPresent())
            departmentStatus = optional.get();
        else throw new RuntimeException("DepartmentStatus NOT found for name : " + name);
        return departmentStatus;
    }
}
