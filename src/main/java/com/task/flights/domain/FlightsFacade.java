package com.task.flights.domain;

import com.task.flights.FlightsController;
import com.task.flights.dto.BaggageDto;
import com.task.flights.dto.CargoDto;
import com.task.flights.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class FlightsFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsController.class);

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
        LOGGER.info(cargoRepository.findAll().toString());
        return cargoRepository.findAll().stream()
                .map(Cargo::dto).collect(Collectors.toList());
    }

    public List<BaggageDto> findBaggage() {
        return baggageRepository.findAll().stream()
                .map(Baggage::dto).collect(Collectors.toList());

    }
}
