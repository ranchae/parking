package com.nhnacademy;

import com.nhnacademy.parking.Car;
import com.nhnacademy.parking.CarNumberScanner;
import com.nhnacademy.parking.ParkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    Car car;
    CarNumberScanner carNumberScanner;
    ParkingSpace parkingSpace;

    @BeforeEach
    @DisplayName("")
    void setUp() {
        carNumberScanner = mock(CarNumberScanner.class);
        parkingSpace = mock(ParkingSpace.class);
    }

    @Test
    @DisplayName("주차장에 들어온 자동차의 번호를 스캔한다.")
    void inCar() {
        //given
        Car car = new Car("라9357");

        //when
        when(carNumberScanner.scan()).thenReturn(car);
        Car newCar = carNumberScanner.scan();

        //then
        assertThat(newCar).isEqualTo(car);
    }

//    @Test
//    @DisplayName("자동차의 차 번호를 스캔한다.")
//    void scanTest() {
//        CarNumberScanner carNumberScanner = new CarNumberScanner();
//        Car newCar = carNumberScanner.scan();
//        int num = 1234;
//        assertThat(carNumberScanner.scan(num)).isEqualTo();
//    }

    @Test
    @DisplayName("자동차를 주차장의 A-1에 주차한다. 들어온 시간을 기록한다.")
    void parkingTest() {
        String num = "1234";
        String name = "A-1";
        Car car = new Car(num);
        ParkingSpace parkingSpace = new ParkingSpace();
        assertThat(parkingSpace.inputCar(name, car)).isTrue();
        LocalTime inTime = LocalTime.now();
        System.out.println("들어온 시간: " + inTime);
    }

    @Test
    @DisplayName("주차장에서 차가 나간다. 주차시간만큼 결제하지 않으면 나갈 수 없다. "
                              + "나간 시간을 출력하고 들어온 시간과 계산하여 정산한다.")
    void outCar() {
//        int money = 10_000;
//        if( money
        LocalTime outTime = LocalTime.now();
        System.out.println("나간 시간 출력: " + outTime);
        System.out.println(outTime - parkingTest.inTime);
                                    //intime을 어떻게 가져와야할까요...
    }
}
