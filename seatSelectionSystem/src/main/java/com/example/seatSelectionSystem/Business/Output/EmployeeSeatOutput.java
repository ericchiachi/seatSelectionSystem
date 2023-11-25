package com.example.seatSelectionSystem.Business.Output;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class EmployeeSeatOutput {
    @Getter
    @Setter
    private long seatId;
    @Getter
    @Setter
    private long employeeId;
    @Getter
    @Setter
    private int floorNumber;
    @Getter
    @Setter
    private int seatNumber;
}
