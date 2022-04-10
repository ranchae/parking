package com.nhnacademy.parking;

public class Zone {
    private static Car carOne;
    private static Car carTwo;

    public static void main(String[] args) {
        EntranceZone entranceZone = new EntranceZone();
        entranceZone.multi();
        ExitZone exitZone = new ExitZone();
        exitZone.multi();
        carOne = new Car("가1111");
        carTwo = new Car("나2222");
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

//        Thread carEntrance1 = new Thread(new EntranceOne());
//        Thread carEntrance2 = new Thread(new EntranceTwo());
//        carEntrance1.start();
//        carEntrance2.start();
//
//        Thread carExit1 = new Thread(new ExitOne());
//        Thread carExit2 = new Thread(new ExitTwo());
//        carExit1.start();
//        carExit2.start();
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
        for (int i = 0; i < 4; i++) {
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

    private void exitSingle() {
        for (int i = 0; i < 4; i++) {
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