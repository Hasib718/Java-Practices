package com.hasib.java.practice;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class Tithi {
    public static HashMap<Long, Pair<BigDecimal, BigDecimal>> dp = new HashMap<>();
    public static HashMap<BigDecimal, BigDecimal> res = new HashMap<>();

    public static long ceilval(BigDecimal x) {
        long y = x.longValue();
        if (x.equals(y)) {
            return y;
        }
        return y + 1;
    }

    public static void main(String[] args) {
        long i, j, k, l, n, m;
        Scanner in = new Scanner(System.in);

        i = in.nextLong();
        k = in.nextLong();
        j = in.nextLong();
        l = in.nextLong();
        n = in.nextLong();

        if (j > i) {
            dp.put(j, new Pair<>(new BigDecimal(l), new BigDecimal(0)));
            dp.put(j - 1, new Pair<>(new BigDecimal(0), new BigDecimal(1)));

            long kola = j - 2;
            while (kola >= i) {
                dp.put(kola, new Pair<>(new BigDecimal(String.valueOf(dp.get(kola + 2).getKey().subtract(dp.get(kola + 1).getKey()))),
                        new BigDecimal(String.valueOf(dp.get(kola + 2).getKey().subtract(dp.get(kola + 1).getKey())))));
                kola--;
            }

            BigDecimal x = new BigDecimal(String.valueOf((new BigDecimal(k).subtract(dp.get(i).getKey())).divide(dp.get(i).getValue())));
            res.put(new BigDecimal(j), new BigDecimal(l));
            res.put(new BigDecimal(j - 1), x);
            kola = j - 2;

            while (kola >= i) {
                res.put(new BigDecimal(kola), res.get(kola + 2).subtract(res.get(kola + 1)));
                kola--;
            }

            if (n > j) {
                kola = j + 1;
                while (kola <= n) {
                    res.put(new BigDecimal(kola), res.get(kola - 1).add(res.get(kola - 2)));
                    kola++;
                }
            } else if (n < i) {
                kola = i - 1;
                while (kola >= n) {
                    res.put(new BigDecimal(kola), res.get(kola + 1).add(res.get(kola + 2)));
                    kola--;
                }
            }

            System.out.println(ceilval(res.get(n)));
        } else {
            long bash = i;
            i = j;
            j = bash;
            bash = k;
            k = l;
            l = bash;

            dp.put(j, new Pair<>(new BigDecimal(l), new BigDecimal(0.0000000)));
            dp.put(j - 1, new Pair<>(new BigDecimal(0.00000), new BigDecimal(1.0000000)));

            long kola = j - 2;
            while (kola >= i) {
                dp.put(kola, new Pair<>(new BigDecimal(String.valueOf(dp.get(kola + 2).getKey().subtract(dp.get(kola + 1).getKey()))),
                        new BigDecimal(String.valueOf(dp.get(kola + 2).getKey().subtract(dp.get(kola + 1).getKey())))));
                kola--;
            }

            BigDecimal x = new BigDecimal(String.valueOf((new BigDecimal(k).subtract(dp.get(i).getKey())).divide(dp.get(i).getValue())));
            res.put(new BigDecimal(j), new BigDecimal(l));
            res.put(new BigDecimal(j - 1), x);
            kola = j - 2;

            while (kola >= i) {
                res.put(new BigDecimal(kola), res.get(kola + 2).subtract(res.get(kola + 1)));
                kola--;
            }

            if (n > j) {
                kola = j + 1;
                while (kola <= n) {
                    res.put(new BigDecimal(kola), res.get(kola - 1).add(res.get(kola - 2)));
                    kola++;
                }
            } else if (n < i) {
                kola = i - 1;
                while (kola >= n) {
                    res.put(new BigDecimal(kola), res.get(kola + 1).add(res.get(kola + 2)));
                    kola--;
                }
            }

            System.out.println(ceilval(res.get(n)));
        }
    }
}
