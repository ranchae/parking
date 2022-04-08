package com.nhnacademy.parking;

public class Parking {
    private ParkingSpace parkingSpace;

    public Parking(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public ParkingSpace getParkingSpace() {
        return this.parkingSpace;
    }

    public int park(String parkingSpaceName, Car car) {
        parkingSpace.add(parkingSpaceName, car);
        return parkingSpace.getCarsNum();
    }
}
