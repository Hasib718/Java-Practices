package com.hasib.java.advance.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class InstanceRefMethod {

    public static void main(String[] args) {
        String hello = "hello$world";
        StringUtils utils = new StringUtils();

        /**
         * Example of "Reference to an instance of a particular object"
         */
        checker(hello, utils::isNotEmpty);
        checker(hello, utils::isEmpty);
        checker(hello, utils::hasSpecialCharacter);

        List<Person> people = List.of(new Person("Jahanara Islam", "jahanara@imam.com", 65),
                new Person("Zahir Raihan", "zahir@raihan.com", 36));

        /**
         * Example of "Reference to an instance method of an arbitrary object of a particular type"
         */
        forEach(people, Person::sendEmail);
    }

    public static void checker(String value, Function<String, Boolean> function) {
        System.out.println(function.apply(value));
    }

    public static void forEach(List<Person> people, Consumer<Person> consumer) {
        for (Person person : people) {
            consumer.accept(person);
        }
    }
}

class StringUtils {
    public boolean isNotEmpty(String value) {
        return value != null && value.length() > 0;
    }

    public boolean isEmpty(String value) {
        return !isNotEmpty(value);
    }

    /**
     * Method for detecting special character is a string
     */
    public boolean hasSpecialCharacter(String value) {
        return value.chars().map(operand -> (char) operand).allMatch(Character::isAlphabetic);
    }
}

class Person {
    private String name, email;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void sendEmail() {
        System.out.println("Sending email to " + email);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}
