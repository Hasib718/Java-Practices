package com.hasib.java.basic;

import java.util.Scanner;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class input1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        boolean okey = true;

        do {
            System.out.println("Enter a Line: ");
            String line = scr.nextLine(); // takes the whole line as input
            System.out.println("You Entered: " + line);

            if ("quit".equals(line)){
                okey = false;
            }
        } while (okey);
    }
}