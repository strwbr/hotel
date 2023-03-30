package com.example.hotel.services;

import com.example.hotel.model.PrepaymentStatus;

import java.util.List;

public interface PrepaymentStatusService {
    List<PrepaymentStatus> getAllPrepaymentStatuses();
    void savePrepaymentStatus(PrepaymentStatus prepaymentStatus);
    PrepaymentStatus getPrepaymentStatusById(long id);
    void deletePrepaymentStatusById(long id);
}
