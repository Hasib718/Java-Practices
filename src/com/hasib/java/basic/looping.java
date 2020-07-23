package com.hasib.java.basic;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class looping {
    public static void main(String[] args) {
        System.out.println("n\t log10(n)\tlog2(n)\t\tloge(n)");
        int n = 1;

        while (n <= 10) {
            double log10 = Math.log10(n);
            double log2 = Math.log(n) / Math.log(2);
            double loge = Math.log(n);

            String row = String.format("%d:" + "\t%.6f" + "\t%.6f" + "\t%.6f", n, log10, log2, loge);
            System.out.println(row);
            n++;
        }
    }
}
