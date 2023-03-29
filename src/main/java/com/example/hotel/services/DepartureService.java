package com.example.hotel.services;

import com.example.hotel.model.Departure;

import java.util.List;

public interface DepartureService {
    List<Departure> getAllDepartures();
    void saveDeparture(Departure departure);
    Departure getDepartureById(long id);
    void deleteDepartureById(long id);
}
