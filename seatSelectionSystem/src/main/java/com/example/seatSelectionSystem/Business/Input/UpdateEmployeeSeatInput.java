package com.example.seatSelectionSystem.Business.Input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UpdateEmployeeSeatInput {
    @Getter
    @Setter
    private long employeeId;
    @Getter
    @Setter
    private long seatId;

}
