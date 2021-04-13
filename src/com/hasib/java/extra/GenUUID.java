package com.hasib.java.extra;/*
 * Created by S M Al Hasib on 1/24/21, 7:44 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 1/24/21, 7:44 PM
 */

/*
 * Created by S M Al Hasib on 4/14/21, 3:01 AM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 4/14/21, 2:54 AM
 */

import java.util.UUID;

public class GenUUID {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
