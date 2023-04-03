package com.example.hotel.repos;

import com.example.hotel.model.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Long> {
    @Query(value = "SELECT name FROM additional_service", nativeQuery = true)
    Collection<String> findAllNames();
}