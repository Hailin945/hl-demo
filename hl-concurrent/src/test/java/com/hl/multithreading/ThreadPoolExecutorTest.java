package com.hl.multithreading;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试类
 *
 * @author Hailin
 * @date 2020/5/27
 */
public class ThreadPoolExecutorTest {

    public void test() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,
                10,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>()
        );
    }
}
