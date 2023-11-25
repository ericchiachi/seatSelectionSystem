package com.example.seatSelectionSystem.Repository;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    // Demo data
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee bob = new Employee(
                    "Bob",
                    "Bob@gmail.com"
            );

            Employee alice = new Employee(
                    "Alice",
                    "Alice@gmail.com"
            );

            Employee issac = new Employee(
                    "Issac",
                    "Issac@gmail.com"
            );

            employeeRepository.saveAll(
                    List.of(bob, alice, issac)
            );
        };
    }
}
