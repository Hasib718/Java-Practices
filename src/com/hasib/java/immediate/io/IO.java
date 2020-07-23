package com.hasib.java.immediate.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class IO {
    public static void main(String[] args)
            throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        do {
            line = reader.readLine();
            line = line.toUpperCase();
            System.out.println(line);
        } while (!"QUIT" .equals(line));
    }
}
