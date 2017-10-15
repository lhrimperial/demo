package com.handy.demo.thread.base.chapter03.part1;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longhairen
 * @create 2017-10-08 8:48
 * @description
 **/
public class Test {
    ReentrantLock lock = null;
    Semaphore semaphore = null;
    ReadWriteLock readWriteLock = null;
    CyclicBarrier cyclicBarrier = null;
    LockSupport lockSupport = null;
    ThreadPoolExecutor threadPoolExecutor = null;

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        ForkJoinPool pool = null;
        Map map = Collections.synchronizedMap(new HashMap());
        List list = Collections.synchronizedList(new ArrayList());

        ConcurrentLinkedQueue concurrentLinkedQueue = null;
        BlockingQueue blockingQueue = null;
        ThreadLocal threadLocal = null;
    }
}
