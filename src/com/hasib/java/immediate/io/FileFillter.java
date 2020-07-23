package com.hasib.java.immediate.io;

import java.io.File;
import java.io.FileFilter;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class FileFillter {
    public static void main(String[] args) {
        File home = new File("D:\\Pictures\\Others\\ETC");

        FileFilter jpgFilter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                String fileName = pathname.getName();
                return fileName.endsWith(".jpg");
            }
        };

        File[] listRoots = home.listFiles(jpgFilter);
        for (File file : listRoots) {
            System.out.println(file.getPath());
        }
    }
}
