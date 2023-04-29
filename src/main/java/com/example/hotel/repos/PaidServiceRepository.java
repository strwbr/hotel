package com.example.hotel.repos;

import com.example.hotel.model.AdditionalService;
import com.example.hotel.model.PaidService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaidServiceRepository extends JpaRepository<PaidService, Long> {

    @Query(value = "SELECT ps.* FROM paid_service ps\n" +
            "JOIN availability_status st ON ps.availability_status_id = st.id\n" +
            "WHERE st.name = :statusName", nativeQuery = true)
    List<PaidService> findAllByAvailabilityStatusName(@Param("statusName") String statusName);
}