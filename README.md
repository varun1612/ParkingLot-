# Parking Lot System

A fully functional Parking Lot system built in Java, demonstrating real-world Object-Oriented Design using multiple design patterns.

---

## Design Patterns Used

| Pattern | Where |
|---|---|
| **Strategy** | Fee calculation (`FlatHourlyRate`, `VehicleBasedRate`) and spot assignment (`NearestFirstStrategy`) |
| **Singleton** | `ParkingLot` — ensures only one instance manages the lot |
| **Observer** | `DisplayBoard` and `AdminAlert` react to parking events |
| **Factory** | `VehicleFactory` and `ParkingSpotFactory` centralize object creation |

---

## Project Structure

```
src/
├── Main.java
├── ParkingLot.java
├── ENUMS/
│   ├── ParkingEvent.java
│   ├── SpotType.java
│   ├── TicketStatus.java
│   └── VehicleType.java
├── MODELS/
│   ├── Vehicle.java
│   ├── ParkingSpot.java
│   ├── ParkingFloor.java
│   └── Ticket.java
├── FEESTRATEGY/
│   ├── FeeCalculator.java       ← Strategy interface
│   ├── FlatHourlyRate.java      ← ₹50/hr flat rate
│   └── VehicleBasedRate.java    ← Different rate per vehicle type
├── SPOTASSIGNMENTSTRATEGY/
│   ├── SpotAssignmentStrategy.java  ← Strategy interface
│   └── NearestFirstStrategy.java   ← Assigns nearest available spot
├── OBSERVER/
│   ├── ParkingObserver.java     ← Observer interface
│   ├── DisplayBoard.java        ← Prints spot info on park/unpark
│   └── AdminAlert.java          ← Alerts when lot is full
└── FACTORY/
    ├── VehicleFactory.java      ← Creates vehicles from string input
    └── ParkingSpotFactory.java  ← Creates spots in bulk per floor
```

---

## How It Works

### Vehicle types and spot mapping
| Vehicle | Spot Type |
|---|---|
| Bike | Small |
| Car | Medium |
| Truck | Large |

### Flow
1. `ParkingLot.initialize()` sets up the lot (Singleton)
2. Observers (`DisplayBoard`, `AdminAlert`) register with the lot
3. `parkVehicle(vehicle)` → `NearestFirstStrategy` finds the nearest matching spot → issues a `Ticket`
4. `unParkVehicle(ticket)` → calculates fee using active fee strategy → frees the spot

---

## Running the Project

```bash
# Compile
javac -d bin src/**/*.java src/*.java

# Run
java -cp bin Main
```

---

## Live Simulator

An interactive UI simulator built in HTML/JS is included:

**[Open parking-lot-simulator.html](./parking-lot-simulator.html)**

Or view it live via GitHub Pages:
`https://varun1612.github.io/ParkingLot/parking-lot-simulator.html`

---

## Edge Cases Handled

- No available spot → throws `IllegalStateException`
- Invalid ticket on exit → throws `IllegalArgumentException`
- Lot full → `AdminAlert` observer fires automatically
- Thread safety → `synchronized` on `initialize()` and `getInstance()`
