package com.example.seatSelectionSystem.Business.Service;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import com.example.seatSelectionSystem.Business.Entity.Seat;
import com.example.seatSelectionSystem.Business.Input.UpdateEmployeeSeatInput;
import com.example.seatSelectionSystem.Repository.EmployeeRepository;
import com.example.seatSelectionSystem.Repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UpdateEmployeeSeatService {

    private final EmployeeRepository employeeRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public UpdateEmployeeSeatService(EmployeeRepository employeeRepository, SeatRepository seatRepository) {
        this.employeeRepository = employeeRepository;
        this.seatRepository = seatRepository;
    }

    private static boolean isCancelSeatInput(Long seatId) {
        return seatId == -1L;
    }
    @Transactional
    public void execute(List<UpdateEmployeeSeatInput> updateEmployeeSeatInputs) {
        for(UpdateEmployeeSeatInput updateEmployeeSeatInput : updateEmployeeSeatInputs) {
            Optional<Employee> currentEmployee = employeeRepository.findById(updateEmployeeSeatInput.getEmployeeId());
            if(!currentEmployee.isPresent()) throw new RuntimeException("employee with id "+ updateEmployeeSeatInput.getEmployeeId() +" not found");

            if(isCancelSeatInput(updateEmployeeSeatInput.getSeatId())) {
                currentEmployee.get().setSeat(null);
            }
            else {
                Optional<Seat> currentSeatingChart = seatRepository.findById(updateEmployeeSeatInput.getSeatId());
                if(!currentSeatingChart.isPresent()) throw new RuntimeException("seat with id "+ updateEmployeeSeatInput.getSeatId() +" not found");
                currentEmployee.get().setSeat(currentSeatingChart.get());
            }

            employeeRepository.save(currentEmployee.get());
        }
    }
}
