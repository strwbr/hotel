package com.example.hotel.services.impl;

import com.example.hotel.model.ExtraBed;
import com.example.hotel.model.JobPosition;
import com.example.hotel.repos.JobPositionRepository;
import com.example.hotel.services.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<JobPosition> optional = repository.findById(id);
        JobPosition jobPosition = null;
        if (optional.isPresent())
            jobPosition = optional.get();
        else throw new RuntimeException("JobPosition NOT found for id : \" + id");
        return jobPosition;
    }

    @Override
    public void deleteJobPositionById(long id) {
        this.repository.deleteById(id);
    }
}
