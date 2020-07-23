package com.hasib.java.immediate.io;

import java.io.File;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class DirectoryExample {
    public static void main(String[] args)
            throws IOException {
        File dir = new File("F:\\myDir");

        dir.mkdir();

        System.out.println("Directory Path: " + dir.getPath());

        //Creating a new file
        File file = new File(dir.getPath() + File.separator + "hello1.txt");

        file.createNewFile();
        System.out.println("File Path: " + file.getPath());
    }
}
