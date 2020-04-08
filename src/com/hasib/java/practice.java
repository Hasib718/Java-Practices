package com.hasib.java;

import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        String[] str = {"abc", "defg", "hijklmn", null, null, null};
        String[] newArray = new String[str.length];

        for(int i=0; i<str.length; i++) {
            if(str[i] != null && str[i].length() > 4) {
                str[i] = null;
            }
        }
        for(String x : str) {
                System.out.print(x + " ");
        }
    }
}
