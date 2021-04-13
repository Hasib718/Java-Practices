package com.hasib.java.advance.lambda;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindArray {

    public static int[] array = new int[100];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + ", ");
        }

        Arrays.stream(array).max().ifPresent(i -> System.out.println("\n\nMaximum:- " + i));
        Arrays.stream(array).min().ifPresent(i -> System.out.println("Minimum:- " + i));
        System.out.println("Mode:- " + mode());
    }

    public static int mode() {
        Map<Integer, Long> countMap = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long compareValue = Arrays.stream(countMap.values()
                .stream()
                .mapToLong(i -> i)
                .toArray())
                .max()
                .getAsLong();

        return countMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), compareValue))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
