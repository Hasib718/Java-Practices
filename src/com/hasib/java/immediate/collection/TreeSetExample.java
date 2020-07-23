package com.hasib.java.immediate.collection;

import java.util.Set;
import java.util.TreeSet;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class TreeSetExample {
}

class Person implements Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    public static void main(String[] args) {
        Set<Person> persons = new TreeSet<>();

        persons.add(new Person("Rokon"));
        persons.add(new Person("Swarna"));
        persons.add(new Person("Rifat"));
        persons.add(new Person("Tabassum"));
        persons.add(new Person("Toufiq"));
        persons.add(new Person("Wadud"));
        persons.add(new Person("Nishat"));
        persons.add(new Person("Mahjabin"));
        persons.add(new Person("Tithi"));

        for (Person p : persons) {
            System.out.println(p);
        }
    }
}