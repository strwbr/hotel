package com.example.hotel.services;

import com.example.hotel.model.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAllJobPositions();
    void saveJobPosition(JobPosition jobPosition);
    JobPosition getJobPositionById(long id);
    void deleteJobPositionById(long id);
}
