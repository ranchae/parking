package com.nhnacademy.parking;

public class TimeCheck {

    public static int time(String s) {
        String[] split = s.split(":");
        int min = Integer.parseInt(split[0]) * 60;
        min = min + Integer.parseInt(split[1]);
        return min;
    }

}
