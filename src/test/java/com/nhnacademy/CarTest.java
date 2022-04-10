package com.nhnacademy;

import com.nhnacademy.parking.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    Car car;
    CarNumberScanner carNumberScanner;
    ParkingSpace parkingSpace;
    TimeCheck min;

    @BeforeEach
    @DisplayName("")
    void setUp() {
        carNumberScanner = mock(CarNumberScanner.class);
        parkingSpace = mock(ParkingSpace.class);
        min = mock(TimeCheck.class);
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
    @DisplayName("주차장에서 차가 나간다. 주차시간만큼 결제하지 않으면 나갈 수 없다. ")
    void outCar() {
        Car car = new Car("라9357");
        LocalTime outTime = LocalTime.now();
        System.out.println("나간 시간 출력: " + outTime);

        Money money = new Money(0);
        int noMoney = 0;
        if (money.equals(noMoney)) {
            System.out.println("요금이 정산되지 않았습니다. 나갈 수 없습니다.");
        }

    }

    @Test
    @DisplayName("들어온 시간과 나간 시간을 이용하여 주차시간을 계산한다.")
    void checkTime() {

        TimeCheck timeCheck = new TimeCheck();
        LocalDateTime startTime = LocalDateTime.of(2022, 12, 20, 9, 10, 45);
        LocalDateTime endTime = LocalDateTime.of(2022, 12, 20, 9, 40, 30);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime) / 60);
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 최초 30분의 경우")
    void pay_first30() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 18, 12, 35, 1);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10_000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 30분 1초의 경우")
    void pay_over30() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 18, 12, 35, 2);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 이틀을 넘겨 주차하는 경우")
    void pay_over2day() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 21, 12, 35, 2);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 50분 주차한 경우")
    void pay_50min() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 18, 12, 55, 1);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 6시간 주차한 경우")
    void pay_6hour() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 18, 18, 5, 1);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }

    @Test
    @DisplayName("계산된 주차시간으로 요금을 지불한다._ 60분 1초의 경우")
    void pay_over60() {

        //최초 30분
        LocalDateTime startTime = LocalDateTime.of(2022, 5, 18, 12, 5, 1);
        LocalDateTime endTime = LocalDateTime.of(2022, 5, 18, 13, 5, 2);
        System.out.println("주차시간(단위:초) " + ChronoUnit.SECONDS.between(startTime, endTime));

        int stayTime = (int) ChronoUnit.SECONDS.between(startTime, endTime);

        int fee = 500;
        if (stayTime <= 1800L) {
            System.out.println((fee*2) + "원");
        } else if (1800L <= stayTime & stayTime <= 2400L) {
            System.out.println((fee*3) + "원");
        } else if (2400L < stayTime & stayTime <= 3000L) {
            System.out.println((fee*4) + "원");
        } else if (3000L < stayTime & stayTime <= 3600L) {
            System.out.println((fee*5) + "원");
        } else if (3600L < stayTime & stayTime <= 4200L) {
            System.out.println((fee*6) + "원");
        } else if (4200L < stayTime & stayTime <= 4800L) {
            System.out.println((fee*7) + "원");
        } else if (4800L < stayTime & stayTime <= 5400L) {
            System.out.println((fee*8) + "원");
        } else if (5400L < stayTime & stayTime <= 6000L) {
            System.out.println((fee*10) + "원");
        } else if (6000L < stayTime & stayTime <= 6600L) {
            System.out.println((fee*11) + "원");
        } else if (6600L < stayTime & stayTime <= 7200L) {
            System.out.println((fee*12) + "원");
        } else if (7200L < stayTime & stayTime <= 7800L) {
            System.out.println((fee*13) + "원");
        } else if (7800L < stayTime & stayTime <= 8400L) {
            System.out.println((fee*14) + "원");
        } else if (8400L < stayTime & stayTime <= 9000L) {
            System.out.println((fee*15) + "원");
        } else if (9000L < stayTime & stayTime <= 9600L) {
            System.out.println((fee*16) + "원");
        } else if (9600L < stayTime & stayTime <= 10200L) {
            System.out.println((fee*17) + "원");
        } else if (10200L < stayTime & stayTime <= 10800L) {
            System.out.println((fee*18) + "원");
        } else if (10800L < stayTime & stayTime <= 178560L) {
            System.out.println((fee = 10000) + "원");
        } else if (178560L < stayTime) {
            System.out.println((fee = 20_000) + "원");
        }
    }


}