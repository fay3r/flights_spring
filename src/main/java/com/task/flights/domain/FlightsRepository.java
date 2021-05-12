package com.task.flights.domain;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

interface FlightsRepository extends Repository<Flight,Long> {

    List<Flight> findAll();
    Flight findByFlightNumberEqualsAndDepartureDateContains
            (@Param("flight_number") Long flightNumber,
             @Param("departure_date") String date);
    List<Flight> findByArrivalAirportCodeEqualsOrDepartureAirportCodeEquals
            (@Param("departure_airport_IATA_code") String arrivalAirportCode,
             @Param("arrival_airport_IATA_code") String departureAirportCode);
}
