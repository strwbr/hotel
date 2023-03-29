package com.example.hotel.repos;

import com.example.hotel.model.ExtraBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraBedRepository extends JpaRepository<ExtraBed, Long> {
}