package com.hasib.java.basic;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class NumberPyramid {
    public static void main(String[] args) {
        int noOfRow = 14, rowCount = 1;

        for (int i = noOfRow; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            rowCount++;
        }
    }
}
