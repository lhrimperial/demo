package com.handy.demo.thread.base.chapter03.part3;




import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author longhairen
 * @create 2017/9/29 0029 下午 7:59
 */
public class ContainerDemo {
    public static void main(String[] args){
        Map synchronizedMap = Collections.synchronizedMap(new HashMap<String, String>());

        ArrayList arrayList = null;

        ArrayBlockingQueue arrayBlockingQueue = null;
        LinkedBlockingQueue linkedBlockingQueue = null;

        ConcurrentLinkedDeque concurrentLinkedDeque = null;
        ConcurrentSkipListMap concurrentSkipListMap = null;
        ConcurrentHashMap concurrentHashMap = null;
    }
}
