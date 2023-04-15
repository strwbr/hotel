package com.example.hotel.services.impl;

import com.example.hotel.model.*;
import com.example.hotel.repos.AddressRepository;
import com.example.hotel.repos.StreetRepository;
import com.example.hotel.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StreetRepository streetRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void saveAddress(Address address) {
        this.addressRepository.save(address);
    }

    @Override
    public Address getAddressById(long id) {
        Optional<Address> optionalAddress =
                addressRepository.findById(id);
        Address address = null;
        if (optionalAddress.isPresent()) {
            address = optionalAddress.get();
        } else {
            throw new RuntimeException("Address NOT found for id : " + id);
        }
        return address;
    }

    @Override
    public void deleteAddressById(long id) {
        this.addressRepository.deleteById(id);
    }

    @Override
    public String getFullAddressString(long id) {
        Address address = this.getAddressById(id);
        Street street = address.getStreet();
        City city = street.getCity();
        Region region = city.getRegion();
        Country country = region.getCountry();

        String fullAddress = country.getName() + ", " + region.getName() + ", " + city.getName() + ", " + street.getName()
                + " " + address.getStreetType().getName() + ", " + address.getHouse() + " стр. " + address.getBuilding()
                + ", " + address.getApartment();

        return fullAddress;
    }
}
