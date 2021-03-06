package com.hasib.java.immediate.generic;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

class Container<T> {
    private static final int MAX_LENGTH = 10;

    private T[] items;
    private int currentIndex = 0;

    public Container() {
        items = (T[]) new Object[MAX_LENGTH];
    }

    public void addItems(T item) {
        if (currentIndex < MAX_LENGTH) {
            items[currentIndex++] = item;
        } else {
            System.out.println("Container is full");
        }
    }

    public T getItem(int index) {
        if (index > MAX_LENGTH) {
            throw new IllegalArgumentException("Index cannot be larger than MAX LENGTH");
        }
        return items[index];
    }

    public void printAll() {
        for (T x : items) {
            System.out.print(x + ", ");
        }
    }
}
public class DemoContainer {




    public static void main(String[] args) {
        Container<Integer> container = new Container<>();

        container.addItems(3);
        container.addItems(7);
        container.addItems(1);

        container.printAll();
    }



}
