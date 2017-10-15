package com.handy.demo.thread.base.chapter05.part1;

/**
 * @author longhairen
 * @create 2017-10-01 8:58
 * @description
 **/
public class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton create!");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
