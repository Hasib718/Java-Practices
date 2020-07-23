package com.hasib.java.advance.thread;

import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class WaitingForThreadToBeFinishedDemo2 {

    private static boolean doneWorking = false;

    public static void main(String[] args) {
        Thread willThrowException = new Thread(() -> {
            throwRuntimeException();
            doneWorking = true;
        });
        willThrowException.start();

        try {
            TimeUnit.MILLISECONDS.sleep(500);

            if (doneWorking) {
                System.out.println("\nThread willThrowException " +
                        "has finished the work");
            } else {
                System.out.println("\nThread willThrowException " +
                        "didn't finished the work!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void throwRuntimeException() {
        throw new RuntimeException("something terribly bad happened");
        }
}
