package com.handy.demo.thread.base.chapter02.part02;

/**
 * @author longhairen
 * @create 2017-09-24 11:12
 * @description
 **/
public class ThreadInterrupted {

    public static void main(String[] args) throws Exception{
//        interrupt1();
        interrupt2();
    }

    public static void interrupt2() throws Exception{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep!");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    public static void interrupt1() throws Exception{
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
                    System.out.println("Thread yield");
                    Thread.yield();
                }
            }
        };

        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
