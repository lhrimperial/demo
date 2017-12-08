package com.handy.demo.thread.base.chapter03.part1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 9:39
 * 重入锁和Condition在JDK中被广泛的使用，比如ArrayBlockingQueue中使用ReentrantLock对put方法做同步，
 * 同时生成两个绑定的Condition对象，notEmpty和notFull，当队列已满时使用notFull.await()等待队列有足够的空间，
 * 当队列有数据放入的时候通知take（）的线程使用notEmpty.signal()；
 * 如果队列为空则消费队列要等待一个非空的信号notEmpty.await()；
 * 当取走数据时通知put（）线程队列已有空闲空间notFull.signal()
 */
public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (Exception i){
            i.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " 线程退出");
        }
    }

    public static void main(String[] args)throws  Exception{
        IntLock lock1 = new IntLock(1);
        IntLock lock2 = new IntLock(2);
        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock2);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        t2.interrupt();
    }
}
