package com.task.flights.domain;

import com.task.flights.dto.*;
import org.decimal4j.util.DoubleRounder;

import java.util.List;

class CargoCalculator {
    private final double LB = 0.4536;
    private final String UNIT = "kg";
    private final int PRECISION = 2;

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

        return FlightDetailsDto.builder()
                .cargoWeight(DoubleRounder.round(cargoWeight, PRECISION))
                .weightUnit(UNIT)
                .baggageWeight(DoubleRounder.round(baggageWeight, PRECISION))
                .totalWeight(DoubleRounder.round(totalWeight, PRECISION))
                .build();
    }

    public AirportDetailsDto countPiecesOnFlight(List<FlightDto> flights, List<BaggageDto> baggageDtos, List<CargoDto> cargoDtos, String airportCode) {
        int arrivedPieces = 0;
        int departurePieces = 0;

        for (FlightDto flightDto : flights) {
            if (flightDto.getArrivalAirportCode().equals(airportCode)) {
                arrivedPieces += baggageDtos.stream()
                        .filter(f -> flightDto.getId() == f.getIdFlight())
                        .map(b -> b.getPieces())
                        .reduce(0L, Long::sum);
                arrivedPieces += cargoDtos.stream().
                        filter(f -> flightDto.getId() == f.getIdFlight())
                        .map(b -> b.getPieces())
                        .reduce(0L, Long::sum);
            }
            if (flightDto.getDepartureAirportCode().equals(airportCode)) {
                departurePieces += baggageDtos.stream()
                        .filter(f -> flightDto.getId() == f.getIdFlight())
                        .map(b -> b.getPieces())
                        .reduce(0L, Long::sum);
                departurePieces += cargoDtos.stream()
                        .filter(f -> flightDto.getId() == f.getIdFlight())
                        .map(b -> b.getPieces())
                        .reduce(0L, Long::sum);
            }
        }

        return AirportDetailsDto.builder()
                .numberOfArrivedPieces(arrivedPieces)
                .numberOfDepartedPieces(departurePieces)
                .numberOfArrives(0)
                .numberOfDeparts(0)
                .build();
    }
}
