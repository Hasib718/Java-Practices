package com.hasib.java.immediate.oop.inheritence;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class Circle {
    double radius;
    String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {
        this.radius = 1.0;
        this.color = "ORANGE";
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }

    public String toString(){
        return ("Radius of The Circle is " + radius
                + "\n" +
                "Color of The Circle is " + color
                + "\n" +
                "Area of THe Circle is " + getArea());
    }
}
