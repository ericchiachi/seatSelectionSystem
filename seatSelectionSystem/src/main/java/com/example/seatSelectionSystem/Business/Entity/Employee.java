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
public class Employee {
    @Id
    @SequenceGenerator(
            name = "EMP_ID_GENERATOR",
            sequenceName = "EMP_ID_GENERATOR",
            initialValue = 12000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EMP_ID_GENERATOR"
    )
    @Column(name = "EMP_ID")
    @Getter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLOOR_SEAT_SEQ", unique = true, nullable = true)
    @Getter
    @Setter
    private Seat seat;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.seat = null;
    }
}
