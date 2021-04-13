package com.hasib.java.advance.lambda;

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

interface GameSprite {

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    default void moveUp(int distance) {
        setY(getY() + distance);
    }

    default void moveDown(int distance) {
        setY(getY() - distance);
    }

    default void moveLeft(int distance) {
        setX(getX() - distance);
    }

    default void moveRight(int distance) {
        setX(getX() + distance);
    }
}

public class DefaultMethodExample implements GameSprite {
    private int X, Y;

    public DefaultMethodExample(int x, int y) {
        X = x;
        Y = y;
    }

    public static void main(String[] args) {
        DefaultMethodExample defaultMethodExample = new DefaultMethodExample(4, 4);

        defaultMethodExample.moveDown(6);

        System.out.println(defaultMethodExample.toString());
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public void setX(int x) {
        this.X = x;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public void setY(int y) {
        this.Y = y;
    }

    @Override
    public String toString() {
        return "DefaultMethodExample{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
