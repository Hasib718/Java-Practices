package com.hasib.java.immediate.io;

import java.io.File;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class FileRenameExample {
    public static void main(String[] args)
            throws IOException {
        File file = new File("F:\\myDir\\");
        File newFile = new File(file.getPath() + File.separator + "new_fuck.txt");
        File oldFile = new File(file.getPath() + File.separator + "old_fuck.txt");
        newFile.createNewFile();
        oldFile.createNewFile();

        File[] listRoots = File.listRoots();

        for(File filE : listRoots) {
            System.out.println(filE.getPath());
        }

        boolean fileRenamed = oldFile.renameTo(newFile);

        if (fileRenamed) {
            System.out.println(oldFile + " renamed to " + newFile);
        } else {
            System.out.println("Renaming " + oldFile + " to " + newFile + " failed.");
        }
    }
}
