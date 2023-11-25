package com.example.seatSelectionSystem.Business.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private String name;
    @Getter
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLOOR_SEAT_SEQ", unique = true, nullable = true)
    @Getter
    @Setter
    private Seat seat;

    private static int count_digit(long x) {
        return (int) Math.floor(Math.log10(x) + 1);
    }

    private static boolean isValidEmployeeId(long id) {
        return count_digit(id) == 5;
    }

    private static boolean isNullOrEmpty(String string) {
        return null == string || string.trim().isEmpty();
    }

    private static boolean isValidName(String name) {
        return !isNullOrEmpty(name);
    }

    private static boolean isValidEmail(String email) {
        return !isNullOrEmpty(email);
    }

    public Employee(long id, String name, String email, Seat seat) {
        if (!isValidEmployeeId(id)) throw new IllegalArgumentException("employee id should be 5 digit");
        if (!isValidName(name)) throw new IllegalArgumentException("name should not be null or empty");
        if (!isValidEmail(email)) throw new IllegalArgumentException("email should not be null or empty");
        this.id = id;
        this.name = name;
        this.email = email;
        this.seat = seat;
    }

    public Employee(String name, String email) {
        if (!isValidName(name)) throw new IllegalArgumentException("name should not be null or empty");
        if (!isValidEmail(email)) throw new IllegalArgumentException("email should not be null or empty");
        this.name = name;
        this.email = email;
        this.seat = null;
    }

    public void setName(String name) {
        if (!isValidName(name)) throw new IllegalArgumentException("name should not be null or empty");
        this.name = name;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) throw new IllegalArgumentException("email should not be null or empty");
        this.email = email;
    }
}
