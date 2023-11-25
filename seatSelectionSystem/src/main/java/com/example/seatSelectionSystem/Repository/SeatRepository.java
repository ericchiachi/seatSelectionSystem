package com.example.seatSelectionSystem.Repository;

import com.example.seatSelectionSystem.Business.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s, e.id FROM Seat s LEFT JOIN s.employee e")
    List<Object[]> getAllSeatsAndRelatedEmployeeId();
}
