package com.handy.demo.thread.base.chapter03.part1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longhairen
 * @create 2017/9/27 0027 上午 9:22
 */
public class ReenterLockCondition implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock!");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " is going on!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " free lock!");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ReenterLockCondition lockCondition = new ReenterLockCondition();
        Thread t1 = new Thread(lockCondition);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " get lock!");
        condition.signal();
        System.out.println(Thread.currentThread().getName() + " free lock!");
        lock.unlock();
    }
}
