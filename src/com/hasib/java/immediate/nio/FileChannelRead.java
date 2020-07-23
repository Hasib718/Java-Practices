package com.hasib.java.immediate.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class FileChannelRead {
    public static void main(String[] args) {
        File inpurtFile = new File("F:\\myDir\\output.txt");
        File outputFile = new File("F:\\myDir\\old_fuck.txt");

        if (!inpurtFile.exists() && !outputFile.exists()) {
            System.out.println("The input file does not exist");
            return;
        }

        try (FileChannel fileChannel = new FileInputStream(inpurtFile).getChannel();
            FileChannel fileChannel1 = new FileOutputStream(outputFile).getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    buffer1.put(b);
                    System.out.print((char) b + " ");
                }

                buffer.clear();
            }
            buffer1.flip();
            fileChannel1.write(buffer1);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
