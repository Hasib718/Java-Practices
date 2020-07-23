package com.hasib.java.advance.thread;

import java.util.Collections;
import java.util.List;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

/**
 * This class is a example of Immutable objects
 */
public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final List<String> friends;

    public ImmutablePerson(String name, int age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFriends() {
        return Collections.unmodifiableList(friends);
    }
}
