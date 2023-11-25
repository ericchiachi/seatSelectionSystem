package com.example.seatSelectionSystem.Repository.DTO;

import com.example.seatSelectionSystem.Business.Entity.Seat;
import lombok.Getter;
import lombok.Setter;

public class SeatWithEmployeeIdDTO {
    @Getter
    @Setter
    private Seat seat;
    @Getter
    @Setter
    private Long employeeId;

    public SeatWithEmployeeIdDTO(Seat seat, Long employeeId) {
        this.seat = seat;
        this.employeeId = employeeId;
    }
}
