package com.example.hotel.repos;

import com.example.hotel.model.RoomTypeExtraBed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeExtraBedRepository extends JpaRepository<RoomTypeExtraBed, Long> {
}