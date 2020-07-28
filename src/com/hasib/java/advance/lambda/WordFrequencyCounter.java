package com.hasib.java.advance.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class WordFrequencyCounter {

    static Map<String, Long> countFrequency(List<String> words) {
        Map<String, Long> frequencyMap = new HashMap<>();

        /**
         *
         * Traditional way of doing things
         *
         for (String word : words) {
         if(!frequencyMap.containsKey(word)) {
         frequencyMap.put(word, 0L);
         }

         Long oldCount = frequencyMap.get(word);
         frequencyMap.put(word, oldCount + 1);
         }
         return frequencyMap;
         */

        /**
         *
         * Using lambda expression
         *
         for (String word : words) {
         frequencyMap.merge(word, 1L, (oldValue, value) -> oldValue+value);
         }
         return frequencyMap;
         */

        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "Bangladesh", "Dhaka", "Hello", "Java", "Lambda");

        System.out.println(countFrequency(words));
    }
}
