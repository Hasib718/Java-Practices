package com.hasib.java.advance.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

/**
 * This is multi threading "Dead Lock" problem. This situation arise
 * because of circular dependency between threads.
 * By avoiding this circular dependency we can resolve deadlock problem.
 */
public class PhilosopherMainWithLock {
    public static void main(String[] args) {
        Lock[] forks = new Lock[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }

        Philosopher2[] philosophers = new Philosopher2[5];
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < philosophers.length; i++) {
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher2("Philosopher " + (i + 1), leftFork, rightFork);
            executorService.execute(philosophers[i]);
        }

        executorService.shutdown();
    }
}

class Philosopher2 extends Thread {
    private final Lock leftFork;
    private final Lock rightFork;
    private String name;

    public Philosopher2(String name, Lock leftFork, Lock rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private static int getRandomEatingTime() {
        return (new Random()).nextInt(100) + 50;
    }

    private void think() {
        log("thinking");
    }

    private void log(String msg) {
        String time = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now());
        String thread = Thread.currentThread().getName();

        System.out.printf("%12s Thread: %s %s: %s%n", time, thread, name, msg);
        System.out.flush();
    }

    private void eat() {
        try {
            log("eating");
            int eatingTime = getRandomEatingTime();
            TimeUnit.NANOSECONDS.sleep(eatingTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            keepThinkingAndEating();
        }
    }

    private void keepThinkingAndEating() {
        think();

        if (leftFork.tryLock()) {
            try {
                log("grabbed left fork");
                if (rightFork.tryLock()) {
                    try {
                        log("grabbed right fork");
                        eat();
                    } finally {
                        log("put down right fork");
                        rightFork.unlock();
                    }
                }
            } finally {
                log("put down left fork");
                leftFork.unlock();
            }
        }
    }
}

