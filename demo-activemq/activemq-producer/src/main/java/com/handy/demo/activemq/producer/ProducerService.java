package com.handy.demo.activemq.producer;

import javax.jms.Destination;

/**
 * @author longhairen
 * @create 2017/5/18 0018 下午 5:45
 */
public interface ProducerService {

    public void sendMessage(Destination destination, final String message);
}
