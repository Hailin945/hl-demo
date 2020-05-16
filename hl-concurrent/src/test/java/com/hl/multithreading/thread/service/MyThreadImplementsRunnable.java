package com.hl.multithreading.thread.service;

/**
 * @author Hailin
 * @date 2020/3/1
 */
public class MyThreadImplementsRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
