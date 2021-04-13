package com.hasib.java.advance.lambda.builderpattern;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class is example of Fluent Programming.
 * As there is no repetition of same words and no 'new' operator for creating instance. Thus the code is short.
 * <p>
 * Here I used builder pattern example.
 */
public class SandwichMaker {
    public static void main(String[] args) {
        /**
         *         Sandwich sandwich = new Sandwich()
         *                 .setBread("White")
         *                 .setMeat("Beef")
         *                 .setCheese("Cheddar")
         *                 .addVegetable("Tomato")
         *                 .addVegetable("Cucumber")
         *                 .make();
         */

        Sandwich.make(sandwich -> sandwich.setBread("white")
                .setMeat("Beef")
                .setCheese("Cheddar")
                .addVegetable("Tomato")
                .addVegetable("Cucumber"));
    }
}

class Sandwich {
    private String bread, meat, cheese;
    private List<String> vegetables = new ArrayList<>();

    private Sandwich() {
    }

    public static Sandwich make(Consumer<Sandwich> sandwichConsumer) {
        System.out.println("Making a sandwich...");
        Sandwich sandwich = new Sandwich();
        sandwichConsumer.accept(sandwich);
        return sandwich;
    }

    public Sandwich setBread(String bread) {
        this.bread = bread;
        return this;
    }

    public Sandwich setMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public Sandwich setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public Sandwich addVegetable(String vegetables) {
        this.vegetables.add(vegetables);
        return this;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }
}
