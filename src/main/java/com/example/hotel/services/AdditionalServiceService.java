package com.example.hotel.services;

import com.example.hotel.model.AdditionalService;

import java.util.Collection;
import java.util.List;

public interface AdditionalServiceService {
    List<AdditionalService> getAllAdditionalServices();
    void saveAdditionalService(AdditionalService additionalService);
    AdditionalService getAdditionalServiceById(long id);
    void deleteAdditionalServiceById(long id);

    Collection<String> getAllAdditionalServiceNames();
    List<AdditionalService> getAllAvailableAdditionalServices();
}
