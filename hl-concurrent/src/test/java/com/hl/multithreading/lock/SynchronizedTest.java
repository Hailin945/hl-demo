package com.hl.multithreading.lock;

import org.junit.jupiter.api.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java同步锁（Synchronized）测试
 *
 * @author Hailin
 * @date 2020/2/28
 */
public class SynchronizedTest {

    /**
     * 同一个锁，锁多个方法。同时只有一个线程可以获取锁，进入同步代码中。
     *
     * @throws InterruptedException 异常信息
     */
    @Test
    public void oneSynchronizedToSomeMethod() throws InterruptedException {
        Product product = new Product();
        Thread thread = new Thread(() -> {
            try {
                product.setCount(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        // 休眠1秒，保证线程先进入setCount()方法
        Thread.sleep(1000);
        System.out.println(product.getCount());
    }

    /**
     * 同一个锁对象下测试，注意要在代码{@code threadPoolExecutor.shutdown();}处加断点。
     *
     * @throws InterruptedException 异常信息
     */
    @Test
    public void oneSynchronizedIncreaseTest() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 0L,
                TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());
        // 实例化测试类的实例，用于调用普通方法，同时作为调用普通方法时的锁对象
        Product product = new Product();
        // 这里的lock对象，是作为锁代码块时的锁用的；不要用字符串常量做锁，锁对象引用改变，会引发change锁事件，即立即释放锁
        Object lock = new Object();

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    /// 调用非线程安全的方法
                    // System.out.println(Thread.currentThread().getName() + ":" + +product.increase());

                    /// 调用加锁了的对象方法
                    // System.out.println(Thread.currentThread().getName() + ":" + +product.increaseSynchronized());

                    /// 调用加锁的静态方法
                    // System.out.println(Thread.currentThread().getName() + ":" + +Product.increaseSynchronizedStatic());

                    // 调用锁代码块的方法
                    System.out.println(Thread.currentThread().getName() + ":" +product.increase(lock));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }

    /**
     * 测试非线程安全的方法
     *
     * @throws InterruptedException 异常信息
     */
    @Test
    public void increaseSynchronizedTest() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 0L,
                TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());
        Product product = new Product();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + +product.increase());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
