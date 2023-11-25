package com.example.seatSelectionSystem.Business.Service;

import com.example.seatSelectionSystem.Business.Entity.Seat;
import com.example.seatSelectionSystem.Business.Output.EmployeeOutput;
import com.example.seatSelectionSystem.Business.Output.EmployeeSeatOutput;
import com.example.seatSelectionSystem.Repository.DTO.SeatWithEmployeeIdDTO;
import com.example.seatSelectionSystem.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadCurrentSeatingChartService {
    private final SeatRepository seatRepository;
    @Autowired
    public ReadCurrentSeatingChartService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<EmployeeSeatOutput> execute() {
        List<Object[]> seatsAndRelatedEmployeeIds = seatRepository.getAllSeatsAndRelatedEmployeeId();

        List<EmployeeSeatOutput> executionResult = new ArrayList<>();
        for(Object[] seatsAndRelatedEmployeeId : seatsAndRelatedEmployeeIds) {
            Seat seat = (Seat) seatsAndRelatedEmployeeId[0];
            Long employeeId = (seatsAndRelatedEmployeeId[1] != null) ? (Long) seatsAndRelatedEmployeeId[1] : -1L;
            EmployeeSeatOutput employeeSeatOutput = new EmployeeSeatOutput();
            employeeSeatOutput.setSeatId(seat.getId());
            employeeSeatOutput.setEmployeeId(employeeId);
            employeeSeatOutput.setFloorNumber(seat.getFloorNumber());
            employeeSeatOutput.setSeatNumber(seat.getSeatNumber());

            executionResult.add(employeeSeatOutput);
        }

        return executionResult;
    }
}
