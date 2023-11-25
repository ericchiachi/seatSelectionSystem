package com.example.seatSelectionSystem.Controller;

import com.example.seatSelectionSystem.Business.Output.EmployeeOutput;
import com.example.seatSelectionSystem.Business.Service.ReadEmployeeWithoutSeatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadEmployeesWithoutSeatController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ReadEmployeeWithoutSeatService readEmployeeWithoutSeatService;

    public ReadEmployeesWithoutSeatController(ReadEmployeeWithoutSeatService readEmployeeWithoutSeatService) {
        this.readEmployeeWithoutSeatService = readEmployeeWithoutSeatService;
    }

    @Autowired

    @GetMapping(path = "api/v1/employee")
    public ResponseEntity<String> readEmployeesWithoutSeat() {
        List<EmployeeOutput> executionResult = readEmployeeWithoutSeatService.execute();
        String returnData = null;
        try {
            returnData = mapOutputToJson(executionResult);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<String>("error while mapping data, check controller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(returnData, HttpStatus.OK);
    }

    private String mapOutputToJson(List<EmployeeOutput> employees) throws JsonProcessingException {
        try {
            return objectMapper.writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
