package com.hasib.java.immediate.io;

import java.io.File;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class FIleExample {
    public static void main(String[] args) {
        File file = new File("hello.txt");

        if (file.exists()) {
            System.out.println("File exists.");
        } else {
            System.out.println("File doesn't exist, lets create one.");

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        currentWorkingDirectory();
    }
    public static void currentWorkingDirectory() {
        String workingDir = System.getProperty("user.dir");
        String newFile = workingDir + File.separator + "hellword.txt";
        File file = new File(newFile);
        System.out.println(file);
    }
}
