package com.hasib.java.immediate.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class ReaderExample {
    public static void main(String[] args) {
        Reader reader = null;

        try {
            reader = new FileReader("F:\\myDir\\input.txt");

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char)c + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
