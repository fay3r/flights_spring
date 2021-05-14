package com.task.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FlightDetailsDto {

    private Double cargoWeight;
    private Double baggageWeight;
    private Double totalWeight;
    private String weightUnit;
}
