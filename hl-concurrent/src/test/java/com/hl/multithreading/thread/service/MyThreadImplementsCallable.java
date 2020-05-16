package com.hl.multithreading.thread.service;

import java.util.concurrent.Callable;

/**
 * @author Hailin
 * @date 2020/3/3
 */
public class MyThreadImplementsCallable implements Callable<String> {

    private int id;

    public MyThreadImplementsCallable(int id) {
        this.id = id;
    }

    /**
     * 任务的具体逻辑，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     *
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        System.out.println("call方法被自动调用，启动线程：" + Thread.currentThread().getName());
        // 模拟耗时逻辑
        for (int i = 10000; i > 0; i--) {
            int ii = i * i;
        }
        return "call()方法被自动调用，任务的结果是id：" + id + ", 线程: " + Thread.currentThread().getName();
    }

}
