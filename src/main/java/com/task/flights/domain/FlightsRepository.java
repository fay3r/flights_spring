package com.task.flights.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface FlightsRepository extends Repository<Flight, Long> {

    List<Flight> findAll();

    Flight findByFlightNumberEqualsAndDepartureDateContains
            (@Param("flight_number") Long flightNumber,
             @Param("departure_date") String date);

    @Query(value = "SELECT * FROM Flight f WHERE (f.departure_airport_IATA_code = ?1 OR f.arrival_airport_IATA_code = ?1) AND f.departure_date LIKE ?2%", nativeQuery = true)
    List<Flight> findAirportUsingCodeAndDate
            (String arrivalAirportCode, String date);
}
