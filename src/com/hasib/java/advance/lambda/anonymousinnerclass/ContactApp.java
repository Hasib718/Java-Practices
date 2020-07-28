package com.hasib.java.advance.lambda.anonymousinnerclass;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by S M Al Hasib on 7/28/20, 1:39 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/28/20, 1:39 PM
 */

interface FilterCriteria {
    boolean match(Contact contact);
}

public class ContactApp {
    public static void main(String[] args) {
        List<Contact> contacts = List.of(new Contact("Will Smith", "will@gmail.com", 50, Contact.Gender.MALE),
                new Contact("Ellen DeGeners", "elen@gmail.com", 60, Contact.Gender.FEMALE),
                new Contact("Sheldon Cooper", "shelly@gmail.com", 10, Contact.Gender.MALE),
                new Contact("Ganja Ganja", "ganja@gmail.com", 23, Contact.Gender.MALE));

        System.out.println(ContactService.findContacts(contacts, contact -> 18 <= contact.getAge() && contact.getAge() <= 25).toString());
    }
}

class ContactService {
    public static List<Contact> findContacts(List<Contact> contacts, FilterCriteria filterCriteria) {
        List<Contact> matchContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (filterCriteria.match(contact)) {
                matchContacts.add(contact);
            }
        }

        return matchContacts;
    }
}

class Contact {
    private String name, email;
    private int age;
    private Gender gender;

    public Contact(String name, String email, int age, Gender gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public Contact() {
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
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}
