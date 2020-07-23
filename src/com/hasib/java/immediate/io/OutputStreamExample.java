package com.hasib.java.immediate.io;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class OutputStreamExample {
    public static void main(String[] args) {
        String destFile = "F:\\myDir\\output.txt";
        String data = "Fucking lady, fucking guy\n" +
                "After fucking,\n" +
                "Telling lie.\n";

        try {
            FileOutputStream fos = new FileOutputStream(destFile);
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
