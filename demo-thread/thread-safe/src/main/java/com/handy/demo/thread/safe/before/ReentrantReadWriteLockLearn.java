package com.handy.demo.thread.safe.before;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author longhairen
 * @create 2017-08-27 14:45
 * @description
 **/
public class ReentrantReadWriteLockLearn {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService service = Executors.newCachedThreadPool();
    }
}
