package com.hasib.java.advance.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class ThreadExecutorsExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100).forEach(i -> {
            executorService.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.printf("Thread: %s is executing task: %d%n", threadName, i);
            });
        });

        executorService.shutdown();
    }
}
