package com.task.flights.domain;


import com.task.flights.dto.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
class Flight {

    @Id
    @Column(name = "flight_id")
    private Long id;
    @Column(name = "flight_number")
    private Long flightNumber;
    @Column(name = "departure_airport_IATA_code")
    private String departureAirportCode;
    @Column(name = "arrival_airport_IATA_code")
    private String arrivalAirportCode;
    @Column(name = "departure_date")
    private String departureDate;

    FlightDto dto() {
        return FlightDto.builder()
                .id(this.id)
                .flightNumber(this.flightNumber)
                .arrivalAirportCode(this.arrivalAirportCode)
                .departureDate(this.departureDate)
                .departureAirportCode(this.departureAirportCode)
                .build();
    }

}
