package com.example.hotel.repos;

import com.example.hotel.model.PaidService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidServiceRepository extends JpaRepository<PaidService, Long> {
}