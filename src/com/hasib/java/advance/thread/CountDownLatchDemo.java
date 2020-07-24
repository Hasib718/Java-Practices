package com.hasib.java.advance.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/25/20, 3:57 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/24/20, 1:00 AM
 */

public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(2);

        Developer developer1 = new Developer(latch, "Developer# 1");
        Developer developer2 = new Developer(latch, "Developer# 2");
        Tester tester = new Tester(latch, "Tester# 1");

        executorService.execute(developer1);
        executorService.execute(developer2);
        executorService.execute(tester);

        executorService.shutdown();
    }
}

class Developer implements Runnable {

    private CountDownLatch latch;
    private String name;

    public Developer(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Task assigned to developer: %s %n", name);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.printf("Task assigned to developer: %s %n", name);
        this.latch.countDown();
    }
}

class Tester implements Runnable {

    private CountDownLatch latch;
    private String name;

    public Tester(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Tester %s waiting for developer to finish their work!%n", name);

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.printf("Testing done by tester: %s !%n", name);
    }
}
