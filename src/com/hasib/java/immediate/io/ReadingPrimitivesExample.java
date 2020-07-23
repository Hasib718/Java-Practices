package com.hasib.java.immediate.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class ReadingPrimitivesExample {
    public static void main(String[] args) {
        String sourceFile = "F:\\myDir\\new_fuck.txt";

        try {
            DataInputStream dis = new DataInputStream(new
                    FileInputStream(sourceFile));

            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readLong());
            System.out.println(dis.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
