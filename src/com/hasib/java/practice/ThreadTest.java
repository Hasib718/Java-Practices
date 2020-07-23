package com.hasib.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class ThreadTest {
    public static List<Integer> test = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("Init Thread");
            synchronized (test) {
                System.out.println("Initializing");
                test.add(1);
                test.add(2);
                test.add(3);
                test.add(4);
            }
        }).start();

        new Thread(() -> {
            System.out.println("Print Thread");
            synchronized (test) {
                System.out.println("Printing");
                System.out.println("ArrayList Size: " + test.size());
            }
        }).start();
    }
}
