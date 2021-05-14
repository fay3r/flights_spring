package com.task.flights.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FlightsConfiguration {

    @Bean
    FlightsFacade flightsFacade(FlightsRepository flightsRepository,
                                BaggageRepository baggageRepository,
                                CargoRepository cargoRepository) {
        CargoCalculator cargoCalculator = new CargoCalculator();
        AirportDetailsCalculator airportDetailsCalculator = new AirportDetailsCalculator();
        return new FlightsFacade(flightsRepository, baggageRepository, cargoRepository, cargoCalculator, airportDetailsCalculator);
    }
}
