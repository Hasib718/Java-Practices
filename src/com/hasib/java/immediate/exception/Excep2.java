package com.hasib.java.immediate.exception;

import java.io.FileReader;
import java.io.IOException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class Excep2 {
    public static void openFile() {
        FileReader reader = null;

        try {
            reader = new FileReader("someFile");
            int i = 0;
            while (i != -1) {
                i = reader.read();
                System.out.println((char) i);
            }
        }catch (IOException e){
            System.out.println("File can't be read!1");
        }finally {
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    System.out.println("File can't be read!2");
                }
            }
            System.out.println("--- File End ---");
        }
    }

    public static void main(String[] args){
        openFile();
    }
}