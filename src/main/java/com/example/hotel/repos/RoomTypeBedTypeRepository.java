package com.example.hotel.repos;

import com.example.hotel.model.RoomTypeBedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeBedTypeRepository extends JpaRepository<RoomTypeBedType, Long> {
}