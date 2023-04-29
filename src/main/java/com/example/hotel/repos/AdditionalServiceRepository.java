package com.example.hotel.repos;

import com.example.hotel.model.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Long> {
    @Query(value = "SELECT name FROM additional_service", nativeQuery = true)
    Collection<String> findAllNames();

    @Query(value = "SELECT ads.* FROM additional_service ads\n" +
            "JOIN availability_status st ON ads.availability_status_id = st.id\n" +
            "WHERE st.name = :statusName", nativeQuery = true)
    List<AdditionalService> findAllByAvailabilityStatusName(@Param("statusName") String statusName);
}