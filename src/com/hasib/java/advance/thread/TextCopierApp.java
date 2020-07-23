package com.hasib.java.advance.thread;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/23/20, 7:04 PM
 */

public class TextCopierApp {
    public static void main(String[] args) {
        TextCopier jugbd = new TextCopier("https://www.jugbd.org/");
        TextCopier masterDevSkill = new TextCopier("https://masterdevskills.com/");

        List<TextCopier> tasks = Arrays.asList(jugbd, masterDevSkill);

        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);

            for (Future<String> future : futures) {
                if (future.isDone()) {
                    String result = future.get();
                    System.out.println(result);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}

class TextCopier implements Callable<String> {
    private String target;

    public TextCopier(String url) {
        this.target = url;
    }

    @Override
    public String call() throws Exception {
        URL url = new URL(target);
        StringBuilder builder = new StringBuilder();

        try (InputStream is = url.openConnection().getInputStream()) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        }

        return builder.toString();
    }
}
