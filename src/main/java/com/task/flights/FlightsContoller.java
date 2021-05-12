package com.task.flights;

import com.task.flights.domain.FlightsFacade;
import com.task.flights.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightsContoller {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsContoller.class);
    private final FlightsFacade flightsFacade;

    FlightsContoller(FlightsFacade flightsFacade){
        this.flightsFacade = flightsFacade;
    }

    @GetMapping("/flights/all")
    List<FlightDto> getFlights(){
        return flightsFacade.findFlights();
    }

    @GetMapping("/flights/flight_details")
    ResponseEntity getFlightDetails(@RequestParam("flightNumber") String flightNumber, @RequestParam("date") String date){
        return new ResponseEntity(flightNumber +" " + date, HttpStatus.OK);

    }

}
