package com.hasib.java.immediate.collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 100; i >= 0; i--) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            dosomework(poll);
        }
    }

    private static void dosomework(Integer value) {
        System.out.println("Doing some work with+ " + value);
    }
}
