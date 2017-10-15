package com.handy.demo.thread.base.chapter05.part1;

/**
 * @author longhairen
 * @create 2017-10-01 8:50
 * @description
 **/
public class Singleton {

    private Singleton() {
        System.out.println("Singleton create!");
    }
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
