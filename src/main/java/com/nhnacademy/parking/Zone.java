package com.nhnacademy.parking;

public class Zone {
    public static void main(String[] args) {
        EntranceZone entranceZone = new EntranceZone();
        entranceZone.multi();
        ExitZone exitZone = new ExitZone();
        exitZone.multi();
    }

    private void multi() {
        Thread entranceOne = new Thread(new EntranceZone.EntranceOne());
        Thread entranceTwo = new Thread(new EntranceZone.EntranceTwo());
        entranceOne.start();
        entranceTwo.start();

        Thread exitOne = new Thread(new ExitZone.ExitOne());
        Thread exitTwo = new Thread(new ExitZone.ExitTwo());
        exitOne.start();
        exitTwo.start();
    }

    class EntranceOne implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                System.out.println("주차장 1번 입구로 들어갑니다.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    class EntranceTwo implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 4; i++) {
                System.out.println("주차장 2번 입구로 들어갑니다.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private void entranceSingle() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                System.out.println("주차장 1번 입구로 자동차가 들어갑니다. ");
            } else {
                System.out.println("주차장 2번 입구로 자동차가 들어갑니다. ");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    static class ExitOne implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                System.out.println("주차장 1번 출구로 나갑니다.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class ExitTwo implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 4; i++) {
                System.out.println("주차장 2번 출구로 나갑니다.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private void single() {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                System.out.println("주차장 1번 출구로 자동차가 나갑니다. ");
            } else {
                System.out.println("주차장 2번 출구로 자동차가 나갑니다. ");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
