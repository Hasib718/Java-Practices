package com.hasib.java.immediate.oop.polymorphism;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

class Shape {
    public String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Circle extends Shape{
    String name;
    public Circle(String name) {
        super(name);
        this.name = name;
    }

    public String getNamE() {
        return name;
    }
}

class Square extends Shape{
    String name;
    public Square(String name){
        super(name);
        this.name = name;
    }

    public String getNamE() {
        return name;
    }
}

class Prism extends Shape{
    String name;
    public Prism(String name){
        super("fuck");
        this.name = name;
    }

    public String getNamE(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class DrawingBoard{
    public void draw(Shape shape){
        System.out.println("Drawing a shape: " + shape.getName());

        String typeName = shape.getClass().getTypeName();
        String superClassType = shape.getClass().getSuperclass().getTypeName();
        System.out.println("TypeName: " + typeName);
        System.out.println("SuperClass Type: " + superClassType);
    }
}