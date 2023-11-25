package com.example.seatSelectionSystem.Business.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Table
public class Seat {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL, optional = true)
    private Employee employee;
    @Column(name = "FLOOR_NO")
    @Getter
    private int floorNumber;
    @Column(name = "SEAT_NO")
    @Getter
    private int seatNumber;

    private static boolean isValidFloorNumber(int floorNumber) {
        return floorNumber != 0;
    }

    private static boolean isValidSeatNumber(int seatNumber) {
        return seatNumber > 0;
    }

    public Seat(Long id, Employee employee, int floorNumber, int seatNumber) {
        this.id = id;
        this.employee = employee;
        if (!isValidFloorNumber(floorNumber)) throw new IllegalArgumentException("floor number can't be 0");
        this.floorNumber = floorNumber;
        if (!isValidSeatNumber(seatNumber)) throw new IllegalArgumentException("seat number can't be 0 or negative");
        this.seatNumber = seatNumber;
    }

    public Seat(int floorNumber, int seatNumber) {
        if (!isValidFloorNumber(floorNumber)) throw new IllegalArgumentException("floor number can't be 0");
        this.floorNumber = floorNumber;
        if (!isValidSeatNumber(seatNumber)) throw new IllegalArgumentException("seat number can't be 0 or negative");
        this.seatNumber = seatNumber;
    }

    public void setFloorNumber(int floorNumber) {
        if (!isValidFloorNumber(floorNumber)) throw new IllegalArgumentException("floor number can't be 0");
        this.floorNumber = floorNumber;
    }

    public void setSeatNumber(int seatNumber) {
        if (!isValidSeatNumber(seatNumber)) throw new IllegalArgumentException("seat number can't be 0 or negative");
        this.seatNumber = seatNumber;
    }
}
