package com.handy.demo.thread.dislock.lock.redis.time;

import java.net.SocketAddress;

/**
 * @author longhairen
 * @create 2017/8/14 0014 下午 2:17
 */
public class TimeClientException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public TimeClientException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TimeClientException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public TimeClientException(SocketAddress address) {
        super(address.toString());
    }

}