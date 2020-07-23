package com.hasib.java.immediate.oop.polymorphism;

import java.util.Scanner;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class DrawingBoardDemo {
    public static void main(String[] args) {
        DrawingBoard drawingBoard = new DrawingBoard();
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter a Name: ");
        Circle circle = new Circle(scr.nextLine());
        System.out.println("Enter another Name: ");
        Square square = new Square(scr.nextLine());

        drawingBoard.draw(circle);
        drawingBoard.draw(square);
    }
}