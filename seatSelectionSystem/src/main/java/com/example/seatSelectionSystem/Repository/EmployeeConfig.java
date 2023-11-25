package com.example.seatSelectionSystem.Repository;

import com.example.seatSelectionSystem.Business.Entity.Employee;
import com.example.seatSelectionSystem.Business.Entity.SeatingChart;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class EmployeeConfig {
    private final SeatingChartRepository seatingChartRepository;

    public EmployeeConfig(SeatingChartRepository seatingChartRepository) {
        this.seatingChartRepository = seatingChartRepository;
    }

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

            SeatingChart[][] seats = new SeatingChart[4][4];
            for(int floorNumber=0; floorNumber<seats.length; floorNumber++) {
                for(int seatNumber=0; seatNumber<seats[0].length; seatNumber++) {
                    seats[floorNumber][seatNumber] = new SeatingChart(
                            floorNumber+1,
                            seatNumber+1
                    );
                }
            }

            bob.setSeat(seats[0][3]);

            employeeRepository.saveAll(
                    List.of(bob, alice, issac)
            );
            List<SeatingChart> flatSeats = Arrays.stream(seats)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            seatingChartRepository.saveAll(flatSeats);
        };
    }
}
