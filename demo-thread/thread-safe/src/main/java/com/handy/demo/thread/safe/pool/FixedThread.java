package com.handy.demo.thread.safe.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author longhairen
 * @create 2017-08-27 20:21
 * @description
 **/
public class FixedThread {
    public static void main(String[] args) {
        testFixedThread();
    }

    public static void testFixedThread(){
        ExecutorService ser = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " start");
                }
            };
            ser.submit(runnable);
        }
        ser.shutdown();
    }
}
