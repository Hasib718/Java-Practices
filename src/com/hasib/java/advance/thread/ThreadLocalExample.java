package com.hasib.java.advance.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class ThreadLocalExample {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        setRandomNumber(sharedObject);

        Thread thread1 = new Thread(() -> {
            setRandomNumber(sharedObject);
        });

        Thread thread2 = new Thread(() -> {
            setRandomNumber(sharedObject);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Value: "+sharedObject.getNumber());
    }

    private static void setRandomNumber(SharedObject sharedObject) {
        sharedObject.setNumber((new Random()).nextInt() * 100);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: "+Thread.currentThread().getName());
        System.out.println("Thread: "+Thread.currentThread().getName()+
                " Value: "+sharedObject.getNumber());
    }
}

class SharedObject {
    private ThreadLocal<Integer> number = new ThreadLocal<>();

    public Integer getNumber() {
        return number.get();
    }

    public void setNumber(Integer number) {
        this.number.set(number);
    }
}
