package com.hasib.java.basic;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class FiboUsingMemoization {

    public static long[] fibo = new long[100];

    public static void main(String[] args) {
        fibo[0] = 0; //CLass fields cannot be changed outside METHODS
        fibo[1] = 1;
        final int arrayLength = 10;
        long[] a = new long[arrayLength];

        for (int i = 0; i < a.length; i++){
            a[i] = fib(i);
        }

        System.out.println("Index\tValue");

        for (int i = 0; i < a.length; i++){
            System.out.println(i + "\t\t" + a[i]);
        }
    }

    public static long fib(long n){
        if(n <= 1) {
            return fibo[(int)n];
        }
        return fibo[(int)n] = fib(n-1) + fib(n-2);
    }
}
