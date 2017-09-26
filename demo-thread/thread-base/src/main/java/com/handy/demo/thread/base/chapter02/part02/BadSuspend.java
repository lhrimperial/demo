package com.handy.demo.thread.base.chapter02.part02;

/**
 * @author longhairen
 * @create 2017-09-24 16:47
 * @description
 **/
public class BadSuspend {

    public static Object object = new Object();

    public static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    public static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
            }
            System.out.println(getName());
        }
    }

    public static void main(String[] args) throws Exception{
        t1.start();
        Thread.sleep(100);
        t2.start();
        System.out.println("t1 resume");
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
