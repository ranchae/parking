package com.nhnacademy;

import com.nhnacademy.parking.Car;
import com.nhnacademy.parking.CarNumberScanner;
import com.nhnacademy.parking.Parking;
import com.nhnacademy.parking.ParkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    Car car;
    CarNumberScanner carNumberScanner;
    Parking parking;
    ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        carNumberScanner = mock(CarNumberScanner.class);
        parkingSpace = mock(ParkingSpace.class);
        parking = new Parking(parkingSpace);
    }

    @Test
    void inCar() {
        //given
        Car car = new Car("라9357");

        //when
        when(carNumberScanner.scan()).thenReturn(car);

        Car newCar = carNumberScanner.scan();

        //then
        assertThat(newCar).isEqualTo(car);
    }

    @Test
    void parkingSpace() {
        String parkingSpaceName = "A1";
        Car car = new Car("라9357");
        when(parkingSpace.getCarsNum()).thenReturn(1);

        int result = parking.park(parkingSpaceName, car);

        assertThat(result).isEqualTo(1);
//        when(parkingSpace.park()).thenReturn(parkingSpace);
//
//        ParkingSpace parkingSpaceNumber = parkingSpace.park();
//
//        assertThat(parkingSpaceNumber).isEqualTo(parking);
    }
}