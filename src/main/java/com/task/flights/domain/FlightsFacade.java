package com.task.flights.domain;

import com.task.flights.FlightsController;
import com.task.flights.dto.*;
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
    private final CargoCalculator cargoCalculator;
    private final AirportDetailsCalculator airportDetailsCalculator;

    public FlightsFacade(FlightsRepository flightsRepository, BaggageRepository baggageRepository,
                         CargoRepository cargoRepository, CargoCalculator cargoCalculator, AirportDetailsCalculator airportDetailsCalculator) {
        this.flightsRepository = flightsRepository;
        this.baggageRepository = baggageRepository;
        this.cargoRepository = cargoRepository;
        this.cargoCalculator = cargoCalculator;
        this.airportDetailsCalculator = airportDetailsCalculator;
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

    public FlightDetailsDto findBaggageUsingFlightId(String flightNumber, String date) {
        try {
            FlightDto flight = flightsRepository.findByFlightNumberEqualsAndDepartureDateContains(Long.parseLong(flightNumber),date).dto();
            List<BaggageDto> baggageDtos = baggageRepository.findByIdFlightEquals(flight.getId()).stream()
                    .map(Baggage::dto).collect(Collectors.toList());
            List<CargoDto> cargoDtos = cargoRepository.findByIdFlightEquals(flight.getId()).stream()
                    .map(Cargo::dto).collect(Collectors.toList());
            return cargoCalculator.countWeightOfCargos(baggageDtos,cargoDtos);
        } catch (NullPointerException nPE){
            LOGGER.info("No flight with this details");
            return new FlightDetailsDto();
        }
    }

    public AirportDetailsDto findAirportUsingCode(String airportCode, String date) {
        try {
            List<FlightDto> flights = flightsRepository.findByArrivalAirportCodeEqualsOrDepartureAirportCodeEquals(airportCode,airportCode)
                    .stream().map(Flight::dto).collect(Collectors.toList());

            List<BaggageDto> baggageDtos = baggageRepository.findAll().stream().map(Baggage::dto).collect(Collectors.toList());
            List<CargoDto> cargoDtos = cargoRepository.findAll().stream().map(Cargo::dto).collect(Collectors.toList());
            AirportDetailsDto airportDetailsDto = cargoCalculator.countPiecesOnFlight(flights, baggageDtos, cargoDtos, airportCode);
            airportDetailsDto = airportDetailsCalculator.sumUpArrivalsAndDepartures(flights,airportCode,airportDetailsDto);
            return airportDetailsDto;
        } catch (NullPointerException nPE){
            LOGGER.info("No airport with this code");
            return new AirportDetailsDto();
        }
    }
}
