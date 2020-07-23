package com.hasib.java.immediate.oop.polymorphism;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class MainCup {
    public static void main(String[] args) {
        CoffeCup mycup = new CoffeCup();

        Liquid genericLiquid = new Liquid();
        Coffee coffee = new Coffee();
        Milk milk = new Milk();

        mycup.addLiquid(genericLiquid);
        mycup.addLiquid(coffee);
        mycup.addLiquid(milk);
    }
}
