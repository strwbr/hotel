package com.example.hotel.services;

import com.example.hotel.model.ExtraBed;

import java.util.List;

public interface ExtraBedService {
    List<ExtraBed> getAllExtraBeds();
    void saveExtraBed(ExtraBed extraBed);
    ExtraBed getExtraBedById(long id);
    void deleteExtraBedById(long id);
}
