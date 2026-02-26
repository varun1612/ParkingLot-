package com.parkinglot.vehicle;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }

    @Override
    public SpotType getRequiredSpotType() { return SpotType.SMALL; }
}
