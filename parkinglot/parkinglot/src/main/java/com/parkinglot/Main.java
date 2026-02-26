package com.parkinglot;

import com.parkinglot.enums.SpotType;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.lot.Floor;
import com.parkinglot.lot.ParkingLot;
import com.parkinglot.spot.ParkingSpot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.vehicle.VehicleFactory;

public class Main {
    public static void main(String[] args) {

        // Setup parking lot
        ParkingLot lot = ParkingLot.getInstance("Central Parking");

        // Floor 1
        Floor f1 = new Floor(1);
        f1.addSpot(new ParkingSpot("F1-S1", SpotType.SMALL));
        f1.addSpot(new ParkingSpot("F1-S2", SpotType.SMALL));
        f1.addSpot(new ParkingSpot("F1-M1", SpotType.MEDIUM));
        f1.addSpot(new ParkingSpot("F1-M2", SpotType.MEDIUM));
        f1.addSpot(new ParkingSpot("F1-L1", SpotType.LARGE));
        lot.addFloor(f1);

        // Floor 2
        Floor f2 = new Floor(2);
        f2.addSpot(new ParkingSpot("F2-S1", SpotType.SMALL));
        f2.addSpot(new ParkingSpot("F2-M1", SpotType.MEDIUM));
        f2.addSpot(new ParkingSpot("F2-L1", SpotType.LARGE));
        lot.addFloor(f2);

        System.out.println("===== Parking Vehicles =====");

        // Park vehicles
        Vehicle bike  = VehicleFactory.createVehicle(VehicleType.BIKE,  "MH-01-AB-1234");
        Vehicle car   = VehicleFactory.createVehicle(VehicleType.CAR,   "MH-02-CD-5678");
        Vehicle truck = VehicleFactory.createVehicle(VehicleType.TRUCK, "MH-03-EF-9012");

        Ticket t1 = lot.parkVehicle(bike);
        Ticket t2 = lot.parkVehicle(car);
        Ticket t3 = lot.parkVehicle(truck);

        System.out.println("\n===== Unparking Vehicles =====");

        // Unpark vehicles
        lot.unparkVehicle(t1.getTicketId());
        lot.unparkVehicle(t2.getTicketId());
        lot.unparkVehicle(t3.getTicketId());
    }
}
