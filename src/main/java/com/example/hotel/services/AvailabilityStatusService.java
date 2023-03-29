package com.example.hotel.services;

import com.example.hotel.model.AvailabilityStatus;

import java.util.List;

public interface AvailabilityStatusService {
    List<AvailabilityStatus> getAllAvailabilityStatuses();
    void saveAvailabilityStatus(AvailabilityStatus availabilityStatus);
    AvailabilityStatus getAvailabilityStatusById(long id);
    void deleteAvailabilityStatusById(long id);
}
