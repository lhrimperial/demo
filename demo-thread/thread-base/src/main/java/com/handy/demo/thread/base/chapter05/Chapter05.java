package com.handy.demo.thread.base.chapter05;

import java.util.concurrent.*;

/**
 * @author longhairen
 * @create 2017-10-01 9:17
 * @description
 **/
public class Chapter05 {
    public static void main(String[] args) {
        Integer integer = new Integer(1);

        Callable c = null;
        Runnable runnable = null;
        Future future = null;
        FutureTask futureTask = null;
        ExecutorService es = Executors.newFixedThreadPool(5);

    }
}
