package com.example.seatSelectionSystem.Business.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SeatingChart {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL, optional = true)
    private Employee employee;
    @Column(name = "FLOOR_NO")
    @Getter
    @Setter
    private int floorNumber;
    @Column(name = "SEAT_NO")
    @Getter
    @Setter
    private int seatNumber;

    public SeatingChart(int floorNumber, int seatNumber) {
        this.floorNumber = floorNumber;
        this.seatNumber = seatNumber;
    }
}
