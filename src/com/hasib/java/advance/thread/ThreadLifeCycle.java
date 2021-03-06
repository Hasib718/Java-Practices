package com.hasib.java.advance.thread;

import java.util.concurrent.TimeUnit;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

/**
 * After compile & run any java program we can inspect JVM current state
 * using #jconsole command in terminal. Meanwhile, we can get information about
 * current state of any java threads through #jstack command in terminal.
 * <p>
 * we can also get current thread is through #jps command in terminal.
 */

public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("My Thread # 1");
        t1.start();

        Thread t2 = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Running");
            }
        });
        t2.setName("My Thread # 2");
        t2.start();

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();
    }
}
