package com.example.hotel.repos;

import com.example.hotel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee ORDER BY surname, name, patronymic", nativeQuery = true)
    List<Employee> findAllOrderBySurnameNamePatronymic();
}