package com.hasib.java.immediate.generic;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

class Tuple<X, Y> {
    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public void setX(X x) {
        this.x = x;
    }

    public X getX() {
        return x;
    }

    public void setY(Y y) {
        this.y = y;
    }

    public Y getY() {
        return y;
    }

    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void showTypes() {
        System.out.println("Type of X is " +
                            x.getClass().getName());
        System.out.println("Type of Y is " +
                            y.getClass().getName());
    }
}

public class Generics1 {
    public static void main(String[] args) {
        Tuple<String, Integer> tuple = new Tuple<String , Integer>("Fuck", 84);

        System.out.println(tuple.toString());
        tuple.showTypes();

        Tuple<String, Tuple<Integer, Integer>> tupleInsideTuple = new Tuple<>("Sayem", new Tuple<>(74, 84));
        System.out.println(tupleInsideTuple.toString());
        tupleInsideTuple.showTypes();
    }
}
