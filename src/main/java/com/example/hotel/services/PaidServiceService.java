package com.example.hotel.services;

import com.example.hotel.model.PaidService;

import java.util.List;

public interface PaidServiceService {
    List<PaidService> getAllPaidServices();
    void savePaidService(PaidService paidService);
    PaidService getPaidServiceById(long id);
    void deletePaidServiceById(long id);
}
