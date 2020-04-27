package com.hasib.java.advance.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

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
