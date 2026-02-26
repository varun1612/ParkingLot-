package com.parkinglot.lot;

import com.parkinglot.enums.SpotType;
import com.parkinglot.spot.ParkingSpot;

import java.util.*;

public class Floor {
    private final int floorNumber;
    private final Map<SpotType, List<ParkingSpot>> availableSpots;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.availableSpots = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            availableSpots.put(type, new ArrayList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        availableSpots.get(spot.getType()).add(spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(SpotType type) {
        return availableSpots.get(type)
                .stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst();
    }

    public int getFloorNumber() { return floorNumber; }
}
