package com.hasib.java.immediate.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class InputStreamExample {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        File file = null;

        try {
            in = new FileInputStream("F:\\myDir\\input.txt");
            file = new File("F:\\myDir\\output12.txt");
            out = new FileOutputStream(file);

            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c + " ");
                out.write(c);
            }
        } catch (IOException e) {
            System.err.println("Could not read file");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    System.err.println("Could close input stream");
                }
            }
        }
    }
}