package com.hasib.java.advance.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:49 AM
 */

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        /**
         * Watch::printCurrentTime --> is a example of lambda expression method reference
         *
         * () -> printCurrentTime()  --> also can be written
         */
        executorService.scheduleAtFixedRate(() -> printCurrentTime(),
                0, 1, TimeUnit.SECONDS);
    }

    private static void printCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
        String formattedCurrentTime = LocalDateTime.now().format(formatter);

        System.out.println(formattedCurrentTime);
    }
}
