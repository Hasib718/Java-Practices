package com.hasib.java.immediate.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class AvailableCharsets {
    public static void main(String[] args) {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<String> keys = map.keySet();
        int count = keys.size();

        System.out.println("Availabe Character Set Count: " + count);

        for (String charsetName : keys) {
            System.out.println(charsetName);
        }
    }
}
