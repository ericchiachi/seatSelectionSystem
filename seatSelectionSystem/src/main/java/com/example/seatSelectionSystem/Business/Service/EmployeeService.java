package com.example.seatSelectionSystem.Business.Service;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import com.example.seatSelectionSystem.Business.Entity.Seat;
import com.example.seatSelectionSystem.Business.Input.UpdateEmployeeSeatInput;
import com.example.seatSelectionSystem.Business.Output.EmployeeOutput;
import com.example.seatSelectionSystem.Repository.EmployeeRepository;
import com.example.seatSelectionSystem.Repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, SeatRepository seatRepository) {
        this.employeeRepository = employeeRepository;
        this.seatRepository = seatRepository;
    }
    public List<EmployeeOutput> getEmployeesWithoutSeat() {
        List<Employee> employees = employeeRepository.findEmployeesWithoutSeat();
        List<EmployeeOutput> executionResult = new ArrayList<>();
        for(Employee employee : employees) {
            EmployeeOutput employeeOutput = new EmployeeOutput();
            employeeOutput.setId(employee.getId());
            employeeOutput.setName(employee.getName());
            employeeOutput.setEmail(employee.getEmail());
            executionResult.add(employeeOutput);
        }

        return executionResult;
    }

    @Transactional
    public void updateEmployeeSeat(List<UpdateEmployeeSeatInput> updateEmployeeSeatInputs) {
        for(UpdateEmployeeSeatInput updateEmployeeSeatInput : updateEmployeeSeatInputs) {
            Optional<Employee> currentEmployee = employeeRepository.findById(updateEmployeeSeatInput.getEmployeeId());
            Optional<Seat> currentSeatingChart = seatRepository.findById(updateEmployeeSeatInput.getSeatId());
            if(!currentEmployee.isPresent()) throw new RuntimeException("employee with id "+ updateEmployeeSeatInput.getEmployeeId() +" not found");
            if(!currentSeatingChart.isPresent()) throw new RuntimeException("seat with id "+ updateEmployeeSeatInput.getSeatId() +" not found");

            currentEmployee.get().setSeat(currentSeatingChart.get());
            employeeRepository.save(currentEmployee.get());
        }
    }
}
