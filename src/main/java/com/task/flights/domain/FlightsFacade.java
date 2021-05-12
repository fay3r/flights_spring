package com.task.flights.domain;

import com.task.flights.dto.FlightDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class FlightsFacade {

    private final FlightsRepository flightsRepository;

    public FlightsFacade(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    public List<FlightDto> findAll() {
        return flightsRepository.findAll().stream()
                .map(Flight::dto).collect(Collectors.toList());
    }
}
