package com.hasib.java.advance.thread;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/*
 * Created by S M Al Hasib on 7/25/20, 3:57 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/25/20, 3:57 AM
 */

public class ForkJoinFrameworkDemo {
    public static void main(String[] args) {
        int[] array = new int[100_000_000];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
//        IntStream.range(0, array.length+1).forEach(i -> {
//            array[i] = random.nextInt(101);
//        });

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SumRecursiveTask recursiveTask = new SumRecursiveTask(array, 0, array.length);

        Long result = forkJoinPool.invoke(recursiveTask);
        System.out.println("Result: " + result);
    }
}

class SumRecursiveTask extends RecursiveTask<Long> {

    public static final int SEQUENTIAL_THRESHOLD = 5000;

    private int[] array;
    private int low;
    private int high;

    public SumRecursiveTask(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected Long compute() {
        if (high - low > SEQUENTIAL_THRESHOLD) {
            int mid = low + (high - low) / 2;

            SumRecursiveTask left = new SumRecursiveTask(array, low, mid);
            SumRecursiveTask right = new SumRecursiveTask(array, mid, high);

            left.fork();
            Long rightAnswer = right.compute();
            Long leftAnswer = left.join();

            return rightAnswer + leftAnswer;
        } else {
            return computeDirectly();
        }
    }

    private @NotNull Long computeDirectly() {
        return LongStream.range(low, high + 1).sum();
    }
}
