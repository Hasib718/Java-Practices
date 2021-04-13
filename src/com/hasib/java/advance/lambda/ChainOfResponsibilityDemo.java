package com.hasib.java.advance.lambda;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.function.UnaryOperator;

/**
 * This class in an example of "Chain of Responsibility Pattern"
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        /**
         *         ProcessingObject<Integer> squarer = new Squarer();
         *         ProcessingObject<Integer> incrementer = new Incrementer();
         *
         *         squarer.setSuccessor(incrementer);
         *
         *         Integer result = squarer.handle(4);
         */

        UnaryOperator<Integer> squarer = a -> a * a;
        UnaryOperator<Integer> increment = a -> a + a;

        Integer result = squarer.andThen(increment).andThen(squarer).apply(2);

        System.out.println(result);
    }
}

class Incrementer extends ProcessingObject<Integer> {

    @Override
    protected Integer handleWork(Integer input) {
        return input + 1;
    }
}

class Squarer extends ProcessingObject<Integer> {

    @Override
    protected Integer handleWork(Integer input) {
        return input * input;
    }
}

abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T t = handleWork(input);
        if (successor != null) {
            return successor.handle(t);
        }

        return t;
    }

    protected abstract T handleWork(T input);
}
