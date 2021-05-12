package com.task.flights.domain;

import com.task.flights.dto.CargoDto;
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
class Cargo {

    @Id
    private Long id;

    @Column(name = "id_cargo")
    private Long idCargo;

    @Column(name = "id_flight")
    private Long idFlight;

    private Long weight;

    @Column(name = "weight_unit")
    private String weightUnit;

    private Long pieces;

    CargoDto dto() {
        return CargoDto.builder()
                .idCargo(this.idCargo)
                .idFlight(this.idFlight)
                .pieces(this.pieces)
                .weight(this.weight)
                .weightUnit(this.weightUnit)
                .build();
    }

}

