package com.example.hotel.services;

import com.example.hotel.model.Arrival;

import java.util.List;

public interface ArrivalService {
    List<Arrival> getAllArrivals();
    void saveArrival(Arrival arrival);
    Arrival getArrivalById(long id);
    void deleteArrivalById(long id);
}
