package com.example.seatSelectionSystem.Business.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeatTest {
    @Test
    public void floor_number_should_not_be_zero(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat(0, 1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat();
            seat.setFloorNumber(0);
        });
    }
    @Test
    public void seat_number_should_not_be_zero_or_negative(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat(1, 0);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat(1, -1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat();
            seat.setSeatNumber(0);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat = new Seat();
            seat.setSeatNumber(-1);
        });
    }
}
