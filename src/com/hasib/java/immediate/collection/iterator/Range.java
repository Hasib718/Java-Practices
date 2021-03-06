package com.hasib.java.immediate.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class Range implements Iterator<Integer>, Iterable<Integer> {
    private int start;
    private int end;
    private int cursor;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        cursor = start;
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor <= end;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            cursor = start;
            throw new NoSuchElementException();
        }

        return cursor++;
    }

    public static void main(String[] args) {
        Range range = new Range(1, 10);
        for (Integer integer : range) {
            System.out.print(integer + " ");
        }
    }
}
