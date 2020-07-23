package com.hasib.java.immediate.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class WritingPrimitivesExample {
    public static void main(String[] args) {
        String destFileName = "F:\\myDir\\new_fuck.txt";

        try {
            DataOutputStream dos = new DataOutputStream(new
                    FileOutputStream(destFileName));

            dos.writeInt(152);
            dos.writeDouble(4.566);
            dos.writeBoolean(true);
            dos.writeLong(Long.MAX_VALUE);
            dos.writeChar(Character.MAX_HIGH_SURROGATE);

            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
