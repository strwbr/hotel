package com.example.hotel.services.impl;

import com.example.hotel.model.Arrival;
import com.example.hotel.repos.ArrivalRepository;
import com.example.hotel.services.ArrivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArrivalServiceImpl implements ArrivalService {

    @Autowired
    private ArrivalRepository arrivalRepository;

    @Override
    public List<Arrival> getAllArrivals() {
        return arrivalRepository.findAll();
    }

    @Override
    public void saveArrival(Arrival arrival) {
        this.arrivalRepository.save(arrival);
    }

    @Override
    public Arrival getArrivalById(long id) {
        Optional<Arrival> optionalArrival =
                arrivalRepository.findById(id);
        Arrival arrival = null;
        if (optionalArrival.isPresent())
            arrival = optionalArrival.get();
        else throw new RuntimeException("Arrival NOT found for id : " + id);
        return arrival;
    }

    @Override
    public void deleteArrivalById(long id) {
        this.arrivalRepository.deleteById(id);
    }
}
