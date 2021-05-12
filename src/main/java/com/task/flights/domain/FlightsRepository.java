package com.task.flights.domain;

import org.springframework.data.repository.Repository;

import java.util.List;

interface FlightsRepository extends Repository<Flight,Long> {

    List<Flight> findAll();
}
