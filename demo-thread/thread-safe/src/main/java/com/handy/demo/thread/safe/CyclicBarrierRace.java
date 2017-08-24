package com.handy.demo.thread.safe;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author longhairen
 * @create 2017/8/24 0024 下午 8:19
 */
public class CyclicBarrierRace {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Runner(cyclicBarrier, "zhangsan"));
        service.submit(new Runner(cyclicBarrier, "lisi"));
        service.submit(new Runner(cyclicBarrier, "wangwu"));
        service.shutdown();
    }
}

class Runner implements Runnable{

    private String name;

    private CyclicBarrier cyclicBarrier;

    public Runner(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(8));
            System.out.println(name + " 准备OK.");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " Go!!");
    }
}
