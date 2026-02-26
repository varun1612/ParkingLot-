package com.parkinglot.lot;

import com.parkinglot.enums.SpotType;
import com.parkinglot.fee.FeeCalculator;
import com.parkinglot.fee.HourlyFeeCalculator;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;

    private final String name;
    private final List<Floor> floors;
    private final FeeCalculator feeCalculator;
    private final Map<String, Ticket> activeTickets; // ticketId -> Ticket

    private ParkingLot(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
        this.feeCalculator = new HourlyFeeCalculator();
        this.activeTickets = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance(String name) {
        if (instance == null) instance = new ParkingLot(name);
        return instance;
    }

    public void addFloor(Floor floor) { floors.add(floor); }

    public Ticket parkVehicle(Vehicle vehicle) {
        SpotType required = vehicle.getRequiredSpotType();

        for (Floor floor : floors) {
            Optional<com.parkinglot.spot.ParkingSpot> spot = floor.findAvailableSpot(required);
            if (spot.isPresent()) {
                spot.get().assign(vehicle);
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, spot.get());
                activeTickets.put(ticketId, ticket);
                System.out.println("Parked " + vehicle.getType()
                    + " [" + vehicle.getLicensePlate() + "]"
                    + " at spot " + spot.get().getSpotId()
                    + " | Ticket: " + ticketId);
                return ticket;
            }
        }
        throw new IllegalStateException("No available spot for " + vehicle.getType());
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Invalid ticket: " + ticketId);

        LocalDateTime exitTime = LocalDateTime.now();
        double fee = feeCalculator.calculate(ticket, exitTime);
        ticket.getSpot().free();

        System.out.println("Unparked " + ticket.getVehicle().getLicensePlate()
            + " | Duration: " + ticket.getEntryTime() + " → " + exitTime
            + " | Fee: ₹" + fee);
        return fee;
    }

    public String getName() { return name; }
}
