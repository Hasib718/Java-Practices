package com.hasib.java.advance.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:38 PM
 */

public class ConstructorRefDemo {
    static Person personBuilder(String name, Integer age, BiFunction<String, Integer, Person> biFunction) {
        return biFunction.apply(name, age);
    }

    static Person personBuilder(String name, Function<String, Person> biFunction) {
        return biFunction.apply(name);
    }

    public static void main(String[] args) {
        System.out.println(personBuilder("Hasib", 22, Person::new));
        System.out.println(personBuilder("Hasib", Person::new));
    }
}
