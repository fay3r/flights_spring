package com.task.flights.domain;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargoRepository extends Repository<Cargo, Long> {

    List<Cargo> findAll();

    List<Cargo> findByIdFlightEquals(@Param("id_flight") Long idFlight);
}
