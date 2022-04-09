package com.nhnacademy.parking;

import java.util.HashMap;

public class ParkingSpace {

    HashMap<String, Car> carHashMap = new HashMap<>();

    public boolean inputCar(String space, Car myCar) {
        carHashMap.put(space, myCar);
        return true;
    }

}

//    public void add(String parkingSpaceName, Car car) {
//        arrayList.add(parkingSpaceName);
//        carList.add(car);
//    }


