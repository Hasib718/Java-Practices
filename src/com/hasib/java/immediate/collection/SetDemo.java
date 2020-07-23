package com.hasib.java.immediate.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class SetDemo {
    public static void main(String[] args) {
        String[] str = {"a", "b"};

        HashSetDemo.main(str);
        LinkedHashSetDemo.main(str);
        TreeSetDemo.main(str);
    }
}

class HashSetDemo {
    public static void main(String[] args) {
        Set<String> cities = new HashSet<>();

        cities.add("Dhaka");
        cities.add("Jessore");
        cities.add("Mymensingh");
        cities.add("Mymensingh");
        cities.add("Cox's Bazar");
        cities.add("Cox's Bazar");

        System.out.println("HashSet\n");
        System.out.println("Total cities: " + cities.size());
        System.out.println(cities);
    }
}

class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> cities = new LinkedHashSet<>();

        cities.add("Dhaka");
        cities.add("Jessore");
        cities.add("Mymensingh");
        cities.add("Mymensingh");
        cities.add("Cox's Bazar");
        cities.add("Cox's Bazar");

        System.out.println("\nLinkedHashSet\n");
        System.out.println("Total cities: " + cities.size());
        System.out.println(cities);
    }
}

class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> cities = new TreeSet<>();

        cities.add("Dhaka");
        cities.add("Jessore");
        cities.add("Mymensingh");
        cities.add("Mymensingh");
        cities.add("Cox's Bazar");
        cities.add("Cox's Bazar");

        System.out.println("\nTreeSet\n");
        System.out.println("Total cities: " + cities.size());
        System.out.println(cities);
    }
}