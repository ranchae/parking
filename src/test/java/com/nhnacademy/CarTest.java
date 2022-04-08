package com.nhnacademy;

import com.nhnacademy.parking.Car;
import com.nhnacademy.parking.CarNumberScanner;
import com.nhnacademy.parking.Parking;
import com.nhnacademy.parking.ParkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    Car car;
    CarNumberScanner carNumberScanner;
    Parking parkingSpace;

    @BeforeEach
    void setUp() {
        carNumberScanner = mock(CarNumberScanner.class);
    }

    @Test
    void inCar() {
        //given
        Car car = new Car("라9357");

        //when
        when(carNumberScanner.scan()).thenReturn(car);

        Car newCar= carNumberScanner.scan();

        //then
        assertThat(newCar).isEqualTo(car);
    }

    @Test
    void parkingSpace() {
        Parking parking = new Parking("");
    }
}