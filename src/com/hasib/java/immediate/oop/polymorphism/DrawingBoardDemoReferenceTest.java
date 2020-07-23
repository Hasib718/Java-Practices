package com.hasib.java.immediate.oop.polymorphism;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class DrawingBoardDemoReferenceTest {
    public static void main(String[] args) {
        Shape shape = new Prism("anything"); //Upcasting of Prism

        System.out.println(((Prism) shape).getNamE()); //Downcasting of shape
        System.out.println(shape.getName());
        shape.name = "asdlfbl";
        System.out.println(shape.getName());

        if (shape instanceof Prism){
            Prism prism = (Prism) shape;
            prism.setName("Toufiq");
        }
        System.out.println(((Prism)shape).getNamE());
    }
}
