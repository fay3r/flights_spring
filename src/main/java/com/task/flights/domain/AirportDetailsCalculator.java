package com.task.flights.domain;

import com.task.flights.dto.AirportDetailsDto;
import com.task.flights.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

class AirportDetailsCalculator {
    public AirportDetailsDto sumUpArrivalsAndDepartures(List<FlightDto> flights, String airportCode, AirportDetailsDto airportDetailsDto) {
        int arrivals = flights.stream().filter(f -> f.getArrivalAirportCode().equals(airportCode)).collect(Collectors.toList()).size();
        int departures = flights.stream().filter(f -> f.getDepartureAirportCode().equals(airportCode)).collect(Collectors.toList()).size();

        airportDetailsDto.setNumberOfArrives(arrivals);
        airportDetailsDto.setNumberOfDeparts(departures);
        return airportDetailsDto;
    }

}
