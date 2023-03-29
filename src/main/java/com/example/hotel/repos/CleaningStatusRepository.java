package com.example.hotel.repos;

import com.example.hotel.model.CleaningStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningStatusRepository extends JpaRepository<CleaningStatus, Long> {
}