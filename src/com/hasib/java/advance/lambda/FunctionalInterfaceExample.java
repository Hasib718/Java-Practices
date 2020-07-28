package com.hasib.java.advance.lambda;

import java.util.function.Supplier;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        Converter upperCaseConverter = (String s) -> s.toUpperCase();
        Converter upperCaseConverter2 = s -> s.toUpperCase();
        Converter upperCaseConverter3 = String::toUpperCase;

        Converter titleCaseConverter = s -> {
            StringBuilder sb = new StringBuilder();
            boolean nextTitleCase = true;

            for (char c : s.toCharArray()) {
                if (Character.isSpaceChar(c)) {
                    nextTitleCase = true;
                } else if (nextTitleCase) {
                    c = Character.toTitleCase(c);
                    nextTitleCase = false;
                }
                sb.append(c);
            }

            return sb.toString();
        };

        System.out.println(upperCaseConverter.apply("hello lambda expression"));
        System.out.println(titleCaseConverter.apply("hello lambda expression"));

        Object o = (Supplier<Object>) () -> null;
    }

    @FunctionalInterface
    public interface Converter {
        String apply(String string);
    }
}
