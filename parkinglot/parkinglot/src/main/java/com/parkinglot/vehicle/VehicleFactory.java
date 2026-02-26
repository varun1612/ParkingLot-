package com.parkinglot.vehicle;

import com.parkinglot.enums.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String licensePlate) {
        return switch (type) {
            case BIKE  -> new Bike(licensePlate);
            case CAR   -> new Car(licensePlate);
            case TRUCK -> new Truck(licensePlate);
        };
    }
}
