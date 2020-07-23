package com.hasib.java.immediate.collection;

import java.util.Scanner;
import java.util.Stack;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class StackDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (StackDemo.isBalanced(in.nextLine())) {
            System.out.println("Balanced");
        } else {
            System.out.println("Imbalanced");
        }
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();

        for (char xchar : chars) {
            if (xchar == '(' || xchar == '{' || xchar == '[') {
                stack.push(xchar);
            } else {
                if (xchar == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (xchar == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (xchar == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }
}
