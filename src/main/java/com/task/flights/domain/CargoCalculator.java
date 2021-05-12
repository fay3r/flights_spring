package com.task.flights.domain;

import com.task.flights.dto.*;
import org.decimal4j.util.DoubleRounder;

import java.util.List;

class CargoCalculator {
    private final double LB = 0.4536;
    private final String UNIT = "kg";
    private final int PRECISION =2;

    FlightDetailsDto countWeightOfCargos(List<BaggageDto> baggage, List<CargoDto> cargo) {
        Double cargoWeight, baggageWeight, totalWeight;
        cargoWeight = cargo.stream()
                .map(x -> {
                    if (!x.getWeightUnit().equals(UNIT)) {
                        return (double) x.getWeight() * LB;
                    } else {
                        return (double) x.getWeight();
                    }
                }).reduce(0.0, Double::sum);

        baggageWeight = baggage.stream()
                .map(x -> {
                    if (x.getWeightUnit().equals(UNIT)) {
                        return (double) x.getWeight() * LB;
                    } else {
                        return (double) x.getWeight();
                    }
                }).reduce(0.0, Double::sum);

        totalWeight = cargoWeight + baggageWeight;

        return new FlightDetailsDto(DoubleRounder.round(cargoWeight,PRECISION), DoubleRounder.round(baggageWeight,PRECISION),DoubleRounder.round(totalWeight,PRECISION),UNIT);
    }

    public AirportDetailsDto countPiecesOnFlight(List<FlightDto> flights, String airportCode, AirportDetailsDto airportDetailsDto) {
        Double arrivedPieces, departuredPieces;

       // arrivedPieces =


        return airportDetailsDto;
    }
}
