package com.example.seatSelectionSystem.Business.Service;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import com.example.seatSelectionSystem.Business.Output.EmployeeOutput;
import com.example.seatSelectionSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadEmployeeWithoutSeatService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public ReadEmployeeWithoutSeatService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeOutput> execute() {
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
}
