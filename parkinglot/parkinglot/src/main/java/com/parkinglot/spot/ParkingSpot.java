package com.parkinglot.spot;

import com.parkinglot.enums.SpotType;
import com.parkinglot.vehicle.Vehicle;

public class ParkingSpot {
    private final String spotId;
    private final SpotType type;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type = type;
    }

    public boolean isAvailable() { return vehicle == null; }

    public void assign(Vehicle v) {
        if (!isAvailable()) throw new IllegalStateException("Spot already occupied");
        this.vehicle = v;
    }

    public void free() { this.vehicle = null; }

    public SpotType getType() { return type; }
    public String getSpotId() { return spotId; }
    public Vehicle getVehicle() { return vehicle; }
}
