package com.example.hotel.repos;

import com.example.hotel.model.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BedTypeRepository extends JpaRepository<BedType, Long> {
    @Query(value = "SELECT name FROM bed_type", nativeQuery = true)
    Collection<String> findAllNames();
}