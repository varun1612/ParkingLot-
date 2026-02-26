package com.parkinglot.fee;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.ticket.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class HourlyFeeCalculator implements FeeCalculator {

    private static final Map<VehicleType, Double> HOURLY_RATES = Map.of(
        VehicleType.BIKE,  20.0,
        VehicleType.CAR,   50.0,
        VehicleType.TRUCK, 100.0
    );

    @Override
    public double calculate(Ticket ticket, LocalDateTime exitTime) {
        long minutes = ChronoUnit.MINUTES.between(ticket.getEntryTime(), exitTime);
        double hours = Math.ceil(minutes / 60.0); // round up to next hour
        double rate = HOURLY_RATES.get(ticket.getVehicle().getType());
        return hours * rate;
    }
}
