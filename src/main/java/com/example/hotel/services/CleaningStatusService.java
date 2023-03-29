package com.example.hotel.services;

import com.example.hotel.model.CleaningStatus;

import java.util.List;

public interface CleaningStatusService {
    List<CleaningStatus> getAllCleaningStatuses();
    void saveCleaningStatus(CleaningStatus cleaningStatus);
    CleaningStatus getCleaningStatusById(long id);
    void deleteCleaningStatusById(long id);
}
