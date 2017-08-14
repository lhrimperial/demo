package com.handy.demo.thread.dislock.lock.zookeeper;

import java.util.concurrent.TimeUnit;

/**
 * @author longhairen
 * @create 2017/8/14 0014 上午 11:43
 */
public interface DistributedLock {

    /**获取锁，如果没有得到就等待*/
    public  void acquire()  throws Exception;

    /**
     * 获取锁，直到超时
     * @param time 超时时间
     * @param unit time参数的单位
     * @return是否获取到锁
     * @throws Exception
     */
    public  boolean acquire (long time, TimeUnit unit)  throws Exception;

    /**
     * 释放锁
     * @throws Exception
     */
    public  void release()  throws Exception;
}
