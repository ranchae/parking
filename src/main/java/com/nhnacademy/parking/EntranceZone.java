package com.nhnacademy.parking;

public class EntranceZone {
    public static void main(String[] args) {
        EntranceZone entranceZone = new EntranceZone();
        entranceZone.multi();
    }

    void multi() {
        Thread entranceOne = new Thread(new EntranceOne());
        Thread entranceTwo = new Thread(new EntranceTwo());
        entranceOne.start();
        entranceTwo.start();
    }

    static class EntranceOne implements Runnable {
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

    static class EntranceTwo implements Runnable {
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

    private void single() {
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

}
