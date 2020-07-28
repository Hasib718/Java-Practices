package com.hasib.java.advance.lambda;

import java.util.function.BiFunction;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class StaticRefDemo {
    static Double convertSum(Integer integer, Integer integer1, BiFunction<Integer, Integer, Double> biFunction) {
        return biFunction.apply(integer, integer1);
    }

    public static void main(String[] args) {
        System.out.println(convertSum(4, 5, StaticRefDemo::process));
    }

    static Double process(Integer integer, Integer integer1) {
        Integer integer2 = integer + integer1;
        return integer2.doubleValue();
    }
}
