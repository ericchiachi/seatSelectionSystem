package com.example.seatSelectionSystem.Controller;

import com.example.seatSelectionSystem.Business.Output.EmployeeOutput;
import com.example.seatSelectionSystem.Business.Output.EmployeeSeatOutput;
import com.example.seatSelectionSystem.Business.Service.ReadCurrentSeatingChartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadCurrentSeatingChartController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ReadCurrentSeatingChartService readCurrentSeatingChartService;
    @Autowired
    public ReadCurrentSeatingChartController(ReadCurrentSeatingChartService readCurrentSeatingChartService) {
        this.readCurrentSeatingChartService = readCurrentSeatingChartService;
    }

    @GetMapping(path = "api/v1/seats")
    public ResponseEntity<String> readCurrentSettingChart() {
        List<EmployeeSeatOutput> seatingChart = readCurrentSeatingChartService.execute();
        String returnData = null;
        try {
            returnData = mapOutputToJson(seatingChart);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<String>("error while mapping data, check controller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(returnData, HttpStatus.OK);
    }

    private String mapOutputToJson(List<EmployeeSeatOutput> seatingChart) throws JsonProcessingException {
        try {
            return objectMapper.writeValueAsString(seatingChart);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
