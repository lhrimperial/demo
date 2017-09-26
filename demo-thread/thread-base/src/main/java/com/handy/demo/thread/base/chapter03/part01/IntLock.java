package com.handy.demo.thread.base.chapter03.part01;

import com.handy.demo.thread.base.chapter02.part03.ThreadGroupName;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longhairen
 * @create 2017/9/25 0025 下午 9:39
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
