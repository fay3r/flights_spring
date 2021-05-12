package com.task.flights.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FlightsConfiguration {

    @Bean
    FlightsFacade flightsFacade(FlightsRepository flightsRepository){
        return new FlightsFacade(flightsRepository);
    }
}
