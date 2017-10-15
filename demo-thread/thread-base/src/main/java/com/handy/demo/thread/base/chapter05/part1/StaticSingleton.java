package com.handy.demo.thread.base.chapter05.part1;

/**
 * @author longhairen
 * @create 2017-10-01 9:01
 * @description
 **/
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("StaticSingleton create!");
    }

    private static class SingletonHodler {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHodler.instance;
    }
}
