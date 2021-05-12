package com.task.flights.domain;

import com.task.flights.dto.AirportDetailsDto;
import com.task.flights.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

class AirportDetailsCalculator {
    public AirportDetailsDto sumUpArrivalsAndDepartures(List<FlightDto> flights,String airportCode) {
        int arrivals = flights.stream().filter(f -> f.getArrivalAirportCode().equals(airportCode)).collect(Collectors.toList()).size() ;
        int departures = flights.stream().filter(f -> f.getDepartureAirportCode().equals(airportCode)).collect(Collectors.toList()).size() ; ;
        return new AirportDetailsDto(arrivals,departures,0,0);
    }

}
