package com.example.hotel.repos;

import com.example.hotel.model.PaidService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaidServiceRepository extends JpaRepository<PaidService, Long> {

}