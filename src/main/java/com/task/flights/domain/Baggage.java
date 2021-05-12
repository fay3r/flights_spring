package com.task.flights.domain;

import com.task.flights.dto.BaggageDto;
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
@Table(name = "baggage")
public class Baggage {


    @Id
    @Column(name = "id_baggage")
    private Long idBaggage;

    @Column(name = "id_flight")
    private Long idFlight;

    private Long weight;

    @Column(name = "weight_unit")
    private String weightUnit;

    private Long pieces;

    BaggageDto dto() {
        return BaggageDto.builder().idBaggage(this.idBaggage)
                .idFlight(this.idFlight)
                .pieces(this.pieces)
                .weight(this.weight)
                .weightUnit(this.weightUnit)
                .build();
    }
}
