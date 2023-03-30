package com.example.hotel.services.impl;

import com.example.hotel.model.JobPosition;
import com.example.hotel.repos.JobPositionRepository;
import com.example.hotel.services.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobPositionRepository repository;

    @Override
    public List<JobPosition> getAllJobPositions() {
        return this.repository.findAll();
    }

    @Override
    public void saveJobPosition(JobPosition jobPosition) {
        this.repository.save(jobPosition);
    }

    @Override
    public JobPosition getJobPositionById(long id) {
        return null;
    }

    @Override
    public void deleteJobPositionById(long id) {
        this.repository.deleteById(id);
    }
}
