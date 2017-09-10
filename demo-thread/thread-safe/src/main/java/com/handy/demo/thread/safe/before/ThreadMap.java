package com.handy.demo.thread.safe.before;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author longhairen
 * @create 2017-08-18 20:43
 * @description
 **/
public class ThreadMap {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.remove("");
        sun.misc.Unsafe unsafe = null;

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}
