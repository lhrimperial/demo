package com.handy.demo.thread.base.chapter03.part2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author longhairen
 * @create 2017/9/29 0029 上午 9:15
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.scheduleWithFixedDelay(new Runnable() {
        //service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
