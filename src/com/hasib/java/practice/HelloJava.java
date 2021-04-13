package com.hasib.java.practice;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

public class HelloJava {
    public static void main(String[] args) {
        int availableProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessor);

        System.out.println(2 << 4);
    }
}
