package com.hasib.java.practice;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class ListSum {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        AtomicInteger sum = new AtomicInteger();

        new Thread(() -> {
            list.forEach(v -> sum.addAndGet(v));
        });
    }
}
