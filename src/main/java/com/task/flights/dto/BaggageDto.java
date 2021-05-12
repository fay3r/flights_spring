package com.task.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaggageDto {

    private Long idBaggage;
    private Long idFlight;
    private Long weight;
    private String weightUnit;
    private Long pieces;
}
