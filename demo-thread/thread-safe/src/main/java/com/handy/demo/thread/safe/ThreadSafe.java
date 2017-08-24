package com.handy.demo.thread.safe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longhairen
 * @create 2017/8/14 0014 下午 7:43
 */
public class ThreadSafe {
    public static void main(String[] args){
        Thread thread = null;
        Integer integer = new Integer(0);
        AtomicInteger atomicInteger = new AtomicInteger();
        ReentrantLock lock = new ReentrantLock();
        BlockingQueue queue = new ArrayBlockingQueue(6);
        AbstractQueuedSynchronizer aqs = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }
        };
    }
}
