package com.handy.demo.thread.base.chapter03.part2;

/**
 * @author longhairen
 * @create 2017/9/29 0029 下午 1:54
 */
public class CaculateThreadCount {
    public static void main(String[] args){
        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU Count " + cpuCount);
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("totalMemory:" + totalMemory + ",freeMemory:" + freeMemory);
    }
}
