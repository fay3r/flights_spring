package com.task.flights.domain;

import com.task.flights.dto.BaggageDto;
import com.task.flights.dto.CargoDto;
import com.task.flights.dto.FlightDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class FlightsFacade {

    private final FlightsRepository flightsRepository;
    private final CargoRepository cargoRepository;
    private final BaggageRepository baggageRepository;

    public FlightsFacade(FlightsRepository flightsRepository, BaggageRepository baggageRepository, CargoRepository cargoRepository) {
        this.flightsRepository = flightsRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<FlightDto> findFlights() {
        return flightsRepository.findAll().stream()
                .map(Flight::dto).collect(Collectors.toList());
    }

    public List<CargoDto> findCargo() {

    }

    public List<BaggageDto> findBaggage() {

    }
}
