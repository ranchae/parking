package com.nhnacademy.parking;

import java.util.Objects;

public class Car {
    private String carNumber;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return this.carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber.equals(car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

}
