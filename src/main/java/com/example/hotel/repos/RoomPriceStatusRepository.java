package com.example.hotel.repos;

import com.example.hotel.model.RoomPriceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPriceStatusRepository extends JpaRepository<RoomPriceStatus, Long> {
}