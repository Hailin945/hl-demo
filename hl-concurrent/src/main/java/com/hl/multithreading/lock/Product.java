package com.hl.multithreading.lock;

import java.time.LocalDateTime;

/**
 * @author Hailin
 * @date 2020/2/28
 */
public class Product {

    private static int count = 0;

    public synchronized void setCount(int count) throws InterruptedException {
        System.out.println("进入方法：setCount, 时间：" + LocalDateTime.now());
        Thread.sleep(5000);
        Product.count = count;
    }

    public synchronized int getCount() {
        System.out.println("进入方法：getCount, 时间：" + LocalDateTime.now());
        return count;
    }

    public int increase() throws InterruptedException {
        count++;
        Thread.sleep(100);
        return count;
    }

    /**
     * synchronized修饰实例方法，、锁是当前实例（this）对象，进入同步代码（实例方法）前要获取当前实例对象锁.
     *
     * @return count加1后的值
     * @throws InterruptedException 异常信息
     */
    public synchronized int increaseSynchronized() throws InterruptedException {
        count++;
        Thread.sleep(100);
        return count;
    }

    /**
     * synchronized修饰静态方法，锁是当前类对象，进入同步代码（静态方法）前要获取当前类对象锁。
     *
     * @return count加1后的值
     * @throws InterruptedException 异常信息
     */
    public synchronized static int increaseSynchronizedStatic() throws InterruptedException {
        count++;
        Thread.sleep(100);
        return count;
    }

    /**
     * synchronized修饰代码块，锁是obj对象，进入同步代码（代码块）前要获取obj对象锁，对同步代码块加锁。
     *
     * @param obj 锁对象
     * @return count加1后的值
     * @throws InterruptedException 异常信息
     */
    public int increase(Object obj) throws InterruptedException {
        synchronized (obj) {
            count++;
            Thread.sleep(100);
            return count;
        }
    }
}
