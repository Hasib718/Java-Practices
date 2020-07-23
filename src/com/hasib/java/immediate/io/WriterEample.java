package com.hasib.java.immediate.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class WriterEample {
    public static void main(String[] args) {
        Writer writer = null;
        String text = "Fucking lady, fucking guy\n" +
                "After fucking,\n" +
                "Telling lie.\n";

        try {
            writer = new FileWriter("F:\\myDir\\old_fuck.txt");
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
