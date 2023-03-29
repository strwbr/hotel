package com.example.hotel.repos;

import com.example.hotel.model.StreetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetTypeRepository extends JpaRepository<StreetType, Long> {
}