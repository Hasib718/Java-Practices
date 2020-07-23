package com.hasib.java.immediate.nio;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class BufferInfo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(8);

        System.out.println("Capacity: " + bb.capacity());
        System.out.println("Limit: " + bb.limit());
        System.out.println("Position: " + bb.position());

//        The mark is not set for a new buffer.
//        Calling the reset() method throws
//        a runtime exception if the mark is not
//        set. If the mark is set, the position
//        is set to the mark value.
        try {
            bb.reset();
            System.out.println("Mark: " + bb.position());
        } catch (InvalidMarkException e) {
            System.out.println("Mark is not set");
        }
    }
}
