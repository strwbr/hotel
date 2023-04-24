package com.example.hotel.repos;

import com.example.hotel.model.RoomPriceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomPriceStatusRepository extends JpaRepository<RoomPriceStatus, Long> {

    @Query(value = "SELECT * FROM room_price_status WHERE name = :name", nativeQuery = true)
    Optional<RoomPriceStatus> findByName(@Param("name") String name);

}