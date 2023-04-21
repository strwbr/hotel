package com.example.hotel.repos;

import com.example.hotel.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Long> {
    @Query(value = "SELECT * FROM employee_status WHERE name = :name", nativeQuery = true)
    Optional<EmployeeStatus> findByName(@Param("name") String name);
}