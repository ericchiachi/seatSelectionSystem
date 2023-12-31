package com.example.seatSelectionSystem.Controller;

import com.example.seatSelectionSystem.Business.Service.UpdateEmployeeSeatService;
import com.example.seatSelectionSystem.Business.Input.UpdateEmployeeSeatInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UpdateEmployeeSeatController {
    private final UpdateEmployeeSeatService updateEmployeeSeatService;
    @Autowired
    public UpdateEmployeeSeatController(UpdateEmployeeSeatService updateEmployeeSeatService) {
        this.updateEmployeeSeatService = updateEmployeeSeatService;
    }

    @PostMapping(path = "api/v1/employee/seat")
    public void updateEmployeeSeatController(@RequestBody Map<Long, Long> requestBody) {
        List<UpdateEmployeeSeatInput> executeTargets = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : requestBody.entrySet()) {
            UpdateEmployeeSeatInput updateEmployeeSeatInput = new UpdateEmployeeSeatInput();
            updateEmployeeSeatInput.setEmployeeId(entry.getKey());
            updateEmployeeSeatInput.setSeatId(entry.getValue());
            executeTargets.add(updateEmployeeSeatInput);
        }

        this.updateEmployeeSeatService.execute(executeTargets);
    }

}
