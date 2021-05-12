package com.task.flights.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface BaggageRepository extends Repository<Baggage,Long> {

    List<Baggage> findAll();

}
