package com.task.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CargoDto {

    private Long idCargo;
    private Long idFlight;
    private Long weight;
    private String weightUnit;
    private Long pieces;

}
