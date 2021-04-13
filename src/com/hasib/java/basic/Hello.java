package com.hasib.java.basic;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int fuck = 718;
        System.out.println(fuck);

        Car car = new Car();
        System.out.println(car.returnSpeed());
    }
}

class Car {
    private int speed;

    public int returnSpeed() {
        return speed + 5;
    }
}
