package com.hasib.java.advance.thread;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class FibonacciTask implements Runnable {
    private long n;
    private String id;

    public FibonacciTask(long n, String id) {
        this.n = n;
        this.id = id;
    }

    private BigDecimal fib(long n) {
        if (n == 0) {
            return BigDecimal.ZERO;
        } else if (n == 1) {
            return BigDecimal.ONE;
        } else {
            return fib(n-1).add(fib(n-2));
        }
    }

    @Override
    public void run() {
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_TIME;

        System.out.println("Starting task "+id+" at "+isoFormatter.format(LocalDateTime.now()));

        BigDecimal fib = fib(n);

        System.out.println("Ending task "+id+" at "+isoFormatter.format(LocalDateTime.now()));
    }

    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread(new FibonacciTask(45, "FibonacciTask# 1"));
        Thread t2 = new Thread(new FibonacciTask(45, "FibonacciTask# 2"));
        Thread t3 = new Thread(new FibonacciTask(45, "FibonacciTask# 3"));
        Thread t4 = new Thread(new FibonacciTask(45, "FibonacciTask# 4"));
        Thread t5 = new Thread(new FibonacciTask(45, "FibonacciTask# 5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
