package com.hl.multithreading.thread.service;

/**
 * @author Hailin
 * @date 2020/3/1
 */
public class MyThreadExtendsThread extends Thread {

    public MyThreadExtendsThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            boolean b = i % 10 == 0;
            System.out.println(b);
            if (b) {
                yield();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
