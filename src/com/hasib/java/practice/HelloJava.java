package com.hasib.java.practice;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class HelloJava {
    public static void main(String[] args) {
        int availableProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessor);
    }
}
