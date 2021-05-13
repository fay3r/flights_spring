package com.task.flights;

import com.task.flights.domain.FlightsFacade;
import com.task.flights.dto.BaggageDto;
import com.task.flights.dto.CargoDto;
import com.task.flights.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsController.class);
    private final FlightsFacade flightsFacade;

    FlightsController(FlightsFacade flightsFacade){
        this.flightsFacade = flightsFacade;
    }

    @CrossOrigin
    @GetMapping(value = "/flights/flight_details", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity getDetailsAboutFlight(@RequestParam("flightNumber") String flightNumber, @RequestParam("date") String date){
        return new ResponseEntity(flightsFacade.findBaggageUsingFlightId(flightNumber,date), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value ="/flights/airport_details", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity getDetailsAboutAirport(@RequestParam("airportCode") String airportCode, @RequestParam("date") String date){
        return new ResponseEntity(flightsFacade.findAirportUsingCode(airportCode,date),HttpStatus.OK);
    }

}
