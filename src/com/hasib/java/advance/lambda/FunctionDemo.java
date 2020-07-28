package com.hasib.java.advance.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

public class FunctionDemo {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student("Tahmid Rafi", 30, Student.Gender.MALE),
                new Student("Abu Bokor", 28, Student.Gender.MALE),
                new Student("Mirza Rehenuma", 27, Student.Gender.FEMALE),
                new Student("James Gosling", 60, Student.Gender.MALE));

        Function<Student, String> nameFunc = Student::getName;
        List<String> names = StudentProcessor.process(students, nameFunc);
        List<String> ages = StudentProcessor.process(students, student -> String.valueOf(student.getAge()));
        List<String> gender = StudentProcessor.process(students, student -> student.getGender().toString());

        List<Student> studentsOlderThen50 = StudentProcessor.filter(students, student -> student.getAge() > 50);
        List<Student> femaleOnly = StudentProcessor.filter(students, student -> student.getGender() == Student.Gender.FEMALE);

        System.out.println(names);
        System.out.println(ages);
        System.out.println(gender);
        System.out.println(studentsOlderThen50);
        System.out.println(femaleOnly);
    }
}

class StudentProcessor {
    public static List<String> process(List<Student> students, Function<Student, String> function) {
        ArrayList<String> list = new ArrayList<>();

        students.forEach(student -> list.add(function.apply(student)));
        return list;
    }

    public static List<Student> filter(List<Student> students, Predicate<Student> predicate) {
        ArrayList<Student> list = new ArrayList<>();

        students.forEach(student -> {
            if (predicate.test(student)) {
                list.add(student);
            }
        });
        return list;
    }
}

class Student {
    private String name;
    private int age;
    private Gender gender;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}
