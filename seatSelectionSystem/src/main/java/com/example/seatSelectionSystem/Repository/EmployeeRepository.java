package com.example.seatSelectionSystem.Repository;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.seat.id IS NULL")
    List<Employee> findEmployeesWithoutSeat();
}
