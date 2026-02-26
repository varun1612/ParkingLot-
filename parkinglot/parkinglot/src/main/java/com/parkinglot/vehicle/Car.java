package com.parkinglot.vehicle;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public SpotType getRequiredSpotType() { return SpotType.MEDIUM; }
}
