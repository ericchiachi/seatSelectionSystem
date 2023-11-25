package com.example.seatSelectionSystem.Business.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    @Test
    public void employee_id_should_be_five_digit(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat =new Seat(1, 1);
            Employee employee = new Employee(1234, "testName", "testEmail", seat);
        });
    }
    @Test
    public void name_should_not_be_null_or_empty(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat =new Seat(1, 1);
            Employee employee = new Employee(12345, "", "testEmail", seat);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat =new Seat(1, 1);
            Employee employee = new Employee(12345, null, "testEmail", seat);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Employee employee = new Employee();
            employee.setName("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Employee employee = new Employee();
            employee.setName(null);
        });
    }

    @Test
    public void email_should_not_be_null_or_empty(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat =new Seat(1, 1);
            Employee employee = new Employee(12345, "testName", "", seat);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Seat seat =new Seat(1, 1);
            Employee employee = new Employee(12345, "testName", null, seat);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Employee employee = new Employee();
            employee.setEmail("");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Employee employee = new Employee();
            employee.setEmail(null);
        });
    }
}
