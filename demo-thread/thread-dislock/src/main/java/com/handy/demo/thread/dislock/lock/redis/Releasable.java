package com.handy.demo.thread.dislock.lock.redis;

/**
 * @author longhairen
 * @create 2017/8/14 0014 下午 2:09
 */
public interface Releasable {
    /**
     * 释放持有的所有资源
     */
    void release();
}
