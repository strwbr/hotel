package com.example.hotel.services.impl;

import com.example.hotel.model.BedType;
import com.example.hotel.repos.BedTypeRepository;
import com.example.hotel.services.BedTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    @Autowired
    private BedTypeRepository repository;

    @Override
    public List<BedType> getAllBedTypes() {
        return this.repository.findAll();
    }

    @Override
    public void saveBedType(BedType bedType) {
        this.repository.save(bedType);
    }

    @Override
    public BedType getBedTypeById(long id) {
        Optional<BedType> optional = this.repository.findById(id);
        BedType bedType = null;
        if(optional.isPresent())
            bedType = optional.get();
        else throw new RuntimeException("BedType NOT found for id : " + id);
        return bedType;
    }

    @Override
    public void deleteBedTypeById(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Collection<String> getAllBedTypesName() {
        return this.repository.findAllNames();
    }
}
