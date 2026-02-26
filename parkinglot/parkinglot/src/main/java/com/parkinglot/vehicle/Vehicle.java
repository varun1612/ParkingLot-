package com.parkinglot.vehicle;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public abstract SpotType getRequiredSpotType();

    public String getLicensePlate() { return licensePlate; }
    public VehicleType getType() { return type; }
}
