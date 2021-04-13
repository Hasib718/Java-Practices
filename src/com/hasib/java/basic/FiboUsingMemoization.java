package com.hasib.java.basic;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

public class FiboUsingMemoization {

    public static long[] fibo = new long[100];

    public static void main(String[] args) {
        fibo[0] = 0; //CLass fields cannot be changed outside METHODS
        fibo[1] = 1;
        final int arrayLength = 30;
        long[] a = new long[arrayLength];

        long preTime = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            a[i] = fib(i);
        }
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));

        System.out.println("Index\tValue");

        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "\t\t" + a[i]);
        }
    }

    public static long fib(long n) {
        if (n <= 1 || fibo[(int) n] != 0) {
            return fibo[(int) n];
        } else {
            return fibo[(int) n] = fib(n - 1) + fib(n - 2);
        }
    }
}
