package com.hl.demo.thread;

import org.junit.Test;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author Hailin
 * @date 2019/12/24
 */
public class ThreadPoolExecutorTest {

    /**
     * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
     * 对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
     * 调用 execute 将重用以前构造的线程（如果线程可用）。
     * 如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
     * 因此，长时间保持空闲的线程池不会使用任何资源。
     *
     * @throws InterruptedException
     */
    @Test
    public void cachedThreadPoolTest() throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i < 6; i++) {
            Thread.sleep(1000);
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println("第" + index + "个线程:" + Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * 创建一个指定工作线程数量的线程池。
     * 每当提交一个任务就创建一个工作线程，如果工作线程数量达到线程池初始的最大数，则将提交的任务存入到池队列中。
     *
     * @throws InterruptedException
     */
    @Test
    public void fixThreadPoolTest() throws InterruptedException {
        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor fixedThreadPool = new ThreadPoolExecutor(
                3, 3, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        for (int i = 1; i <= 5; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("第" + index + "个线程:" + Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            if (i == 5) {
                // 由于设置最大线程数为3，所以在输出三个数后等待2秒后才继续输出。
                Thread.sleep(3000);
            }
        }
    }

    /**
     * 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
     */
    @Test
    public void scheduledThreadPoolTest() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("延迟3秒");
            }
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    /**
     * 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
     */
    @Test
    public void scheduledThreadPoolTest2() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟一秒后每三秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
        while (true) {
            System.out.println(LocalTime.now());
            Thread.sleep(1000);
        }
    }

    @Test
    public void singleThreadPoolTest() throws InterruptedException {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i <= 5; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "个线程:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(10000);
    }
}

