package com.hl.multithreading.thread.test;

import com.hl.multithreading.thread.service.MyThreadExtendsThread;
import com.hl.multithreading.thread.service.MyThreadImplementsRunnable;
import org.junit.jupiter.api.Test;

/**
 * @author Hailin
 * @date 2020/3/1
 */
public class CreateThreadTest {

    @Test
    public void myThreadExtendsThreadTest() {
        Thread t1 = new MyThreadExtendsThread("线程1");
        Thread t2 = new MyThreadExtendsThread("线程2");
        t1.start();
        t2.start();
    }

    @Test
    public void myThreadImplementsRunnable() {
        new Thread(new MyThreadImplementsRunnable()).start();
        new Thread(new MyThreadImplementsRunnable()).start();
    }

    @Test
    public void threadJoinTest() throws InterruptedException {
        Thread t1 = new MyThreadExtendsThread("线程1");
        Thread t2 = new MyThreadExtendsThread("线程2");
        Thread t3 = new MyThreadExtendsThread("线程3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println(Thread.currentThread().getName() + ": END" );
    }

    @Test
    public void threadYieldTest() throws InterruptedException {
        Thread t1 = new MyThreadExtendsThread("线程1");
        Thread t2 = new MyThreadExtendsThread("线程2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + ": END" );
    }
}
