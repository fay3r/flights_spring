package com.task.flights.dto;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AirportDetailsDto {

    private Integer numberOfDeparts;
    private Integer numberOfArrives;
    private Integer numberOfArrivedPieces;
    private Integer numberOfDepartedPieces;

}
