package com.hasib.java.advance.thread;

import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class CricketScoreChecker extends Thread {
    private volatile boolean keepChecking = true;

    @Override
    public void run() {
        while (keepChecking) {
            checkScoreAndPrintTheResult();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkScoreAndPrintTheResult() {
        System.out.println("Current score is: BAN 125/2 (10 ov. target 220)");
    }

    public void shutDown() {
        keepChecking = false;
    }
}

class CricketScoreCheckerDemo {
    public static void main(String[] args) {
        CricketScoreChecker cricketScoreChecker = new CricketScoreChecker();
        cricketScoreChecker.start();

        try {
            TimeUnit.HOURS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cricketScoreChecker.shutDown();
    }
}