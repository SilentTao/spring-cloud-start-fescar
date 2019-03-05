package com.silent.controller;

/**
 * \* User: silent
 * \* Date: 01/03/19 Time: 14:04
 * \* Description:
 * \
 */
public class CacheBugService {

    private static long count = 0;

    private static long calc() throws InterruptedException {
        final CacheBugService test = new CacheBugService();
        Thread th1 = new Thread(() -> {
            test.add10000W();
        });
        Thread th2 = new Thread(() -> {
            test.add10000W();
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        return count;
    }


    public static void main(String[] args) {

        try {
            System.out.println(calc());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void add10000W() {
        int idx = 0;
        while (idx++ < 100000000) {
            count += 1;
        }
    }
}
