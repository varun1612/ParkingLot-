# Parking Lot - LLD Design Pattern Practice

## Project Structure

```
src/main/java/com/parkinglot/
├── Main.java                        ← Entry point, run this
├── enums/
│   ├── VehicleType.java             (BIKE, CAR, TRUCK)
│   ├── SpotType.java                (SMALL, MEDIUM, LARGE)
│   └── PaymentStatus.java           (PENDING, COMPLETED)
├── vehicle/
│   ├── Vehicle.java                 (abstract)
│   ├── Bike.java
│   ├── Car.java
│   ├── Truck.java
│   └── VehicleFactory.java          ← Factory Pattern
├── spot/
│   └── ParkingSpot.java
├── ticket/
│   └── Ticket.java
├── fee/
│   ├── FeeCalculator.java           ← Strategy Pattern (interface)
│   └── HourlyFeeCalculator.java     ← Concrete strategy
└── lot/
    ├── Floor.java
    └── ParkingLot.java              ← Singleton Pattern
```

## Design Patterns Used

| Pattern    | Where                                        |
|------------|----------------------------------------------|
| Singleton  | ParkingLot — one instance manages all state  |
| Factory    | VehicleFactory — creates Bike/Car/Truck       |
| Strategy   | FeeCalculator — swap fee logic easily         |
| Abstract   | Vehicle — common interface for all vehicles   |

## How to Run in VS Code

### Prerequisites
- Java 17+ installed
- VS Code with **Extension Pack for Java** installed
  (Publisher: Microsoft — search it in Extensions tab)

### Steps
1. Open the `parkinglot` folder in VS Code: `File → Open Folder`
2. Wait for Java extension to index the project (bottom status bar)
3. Open `Main.java`
4. Click the **▶ Run** button above the `main` method
   OR press `Ctrl+F5` to run without debugging

### Expected Output
```
===== Parking Vehicles =====
Parked BIKE [MH-01-AB-1234] at spot F1-S1 | Ticket: <uuid>
Parked CAR [MH-02-CD-5678] at spot F1-M1 | Ticket: <uuid>
Parked TRUCK [MH-03-EF-9012] at spot F1-L1 | Ticket: <uuid>

===== Unparking Vehicles =====
Unparked MH-01-AB-1234 | Duration: ... | Fee: ₹0.0
Unparked MH-02-CD-5678 | Duration: ... | Fee: ₹0.0
Unparked MH-03-EF-9012 | Duration: ... | Fee: ₹0.0
```
> Fee shows 0.0 because park + unpark happens instantly in the demo.
> In real use, fee will reflect actual duration.

## Things to Try (Practice)

- Add a new vehicle type (e.g., `Van`) — tests your understanding of Factory + Abstract class
- Add a `FlatRateFeeCalculator` — tests Strategy pattern
- Add a `DisplayBoard` that updates on park/unpark — implement Observer pattern
- Make `parkVehicle` thread-safe for multiple gates — use `synchronized` or `ReentrantLock`
