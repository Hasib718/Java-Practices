package com.hasib.java.immediate.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class FileChannelWrite {
    public static void main(String[] args) {
        File outputFile = new File("F:\\myDir\\new_fuck.txt");
        String text = "I want to break free";

        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            FileChannel fileChannel = fos.getChannel();

            byte[] bytes = text.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(bytes);

            fileChannel.write(buffer);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
