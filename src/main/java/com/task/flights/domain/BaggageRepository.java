package com.task.flights.domain;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaggageRepository extends Repository<Baggage, Long> {

    List<Baggage> findAll();

    List<Baggage> findByIdFlightEquals(@Param("id_flight") Long idFlight);

}
