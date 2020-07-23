package com.hasib.java.immediate.oop.polymorphism;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

class Liquid {
    public void swirl(boolean clockwiae) {
        System.out.println("Swirling Liquid");
    }
}

class Coffee extends Liquid {
    @Override
    public void swirl(boolean clockwiae) {
        System.out.println("Swirling Coffee");
    }
}

class Milk extends Liquid{
    @Override
    public void swirl(boolean clockwiae) {
        System.out.println("Swirling Milk");
    }
}

public class CoffeCup {
    private Liquid innerLiquid;

    void addLiquid(Liquid liq){
        innerLiquid = liq;

        innerLiquid.swirl(false);
    }
}
