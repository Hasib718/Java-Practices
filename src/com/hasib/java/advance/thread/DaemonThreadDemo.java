package com.hasib.java.advance.thread;

import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/25/20, 3:57 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/25/20, 2:10 AM
 */

public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("I'm a daemon thread and I'm running");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("Main Thread! is running");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Main thread! still running!");
        System.out.println("Main thread is going to stop now!");
    }
}
