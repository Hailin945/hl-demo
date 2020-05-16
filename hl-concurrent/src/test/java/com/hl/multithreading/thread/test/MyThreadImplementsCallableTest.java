package com.hl.multithreading.thread.test;

import com.hl.multithreading.thread.service.MyThreadImplementsCallable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Hailin
 * @date 2020/3/3
 */
public class MyThreadImplementsCallableTest {

    @Test
    public void test() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        List<Future<String>> futureList = new ArrayList<>(16);
        for (int i = 0; i < 100; i++) {
            Future<String> future = threadPoolExecutor.submit(new MyThreadImplementsCallable(i));
            futureList.add(future);
        }
        threadPoolExecutor.shutdown();

        futureList.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

}
