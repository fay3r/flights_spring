package com.task.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FlightDto {

    private Long id;
    private Long flightNumber;
    private String departureAirportCode;
    private String arrivalAirportCode;
    private String departureDate;

}
