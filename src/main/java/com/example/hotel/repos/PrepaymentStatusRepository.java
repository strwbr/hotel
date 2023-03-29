package com.example.hotel.repos;

import com.example.hotel.model.PrepaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrepaymentStatusRepository extends JpaRepository<PrepaymentStatus, Long> {
}