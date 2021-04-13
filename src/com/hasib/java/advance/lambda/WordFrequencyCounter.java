package com.hasib.java.advance.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

public class WordFrequencyCounter {

    static Map<String, Long> countFrequency(List<String> words) {

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
         Map<String, Long> frequencyMap = new HashMap<>();
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
//        List<Integer> words = Arrays.asList(2, 4, 5, 5, 6, 8, 2, 1, 8, 3, 8, 4, 0, 3, 7, 4, 2, 7, 8, 9, 3);

        System.out.println(countFrequency(words));
    }
}
