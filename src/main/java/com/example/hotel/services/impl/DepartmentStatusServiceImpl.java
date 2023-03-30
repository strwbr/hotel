package com.example.hotel.services.impl;

import com.example.hotel.model.DepartmentStatus;
import com.example.hotel.repos.DepartmentStatusRepository;
import com.example.hotel.services.DepartmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteDepartmentStatusById(long id) {
        this.repository.deleteById(id);
    }
}
