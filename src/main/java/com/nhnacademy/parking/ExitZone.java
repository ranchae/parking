package com.nhnacademy.parking;

public class ExitZone {

    public static void main(String[] args) {
        ExitZone exitZone = new ExitZone();
        exitZone.multi();
    }
    
    void multi() {
        Thread exitOne = new Thread(new ExitOne());
        Thread exitTwo = new Thread(new ExitTwo());
        exitOne.start();
        exitTwo.start();
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

    public static class carOne implements Runnable {
        @Override
        public void run() {
        }
    }

    public static class carFour implements Runnable {
        @Override
        public void run() {
        }
    }
}
