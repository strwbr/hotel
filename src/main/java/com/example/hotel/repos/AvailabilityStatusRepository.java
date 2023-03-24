package com.example.hotel.repos;

import com.example.hotel.model.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityStatusRepository extends JpaRepository<AvailabilityStatus, Long> {
}