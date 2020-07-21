package com.hl.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hailin
 * @date 2020/2/27
 */
public class AtomicIntegerTest {

    private static final int THREADS_COUNT = 10;
    private static int count = 0;

    private void increase() {
        count++;
    }

    @Test
    public void test() throws InterruptedException {
        new ThreadPoolExecutor(4, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        Thread.currentThread().getThreadGroup();
        Thread.sleep(10000);
        System.out.println(count);
    }

    @Test
    public void test1() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(222);
        System.out.println(atomicInteger.get());
    }
}
