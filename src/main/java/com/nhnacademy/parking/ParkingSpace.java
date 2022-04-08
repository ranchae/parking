package com.nhnacademy.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
    List<String> arrayList = new ArrayList<>();
    List<Car> carList = new ArrayList<>();

    public int getCarsNum() {
        return 0;
    }

    public void add(String parkingSpaceName, Car car) {
        arrayList.add(parkingSpaceName);
        carList.add(car);
    }

}
