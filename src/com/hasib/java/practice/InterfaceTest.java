package com.hasib.java.practice;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

interface Test {
    void show();

    interface TestAgain {
        void againShow();
    }
}

public class InterfaceTest implements Test {

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.show();
    }

    @Override
    public void show() {
        System.out.println("From Test");
    }
}
