package com.handy.demo.distribute.webb.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/9/13 0013 下午 3:06
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException, MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("rocketmq");
        /**
         * Push Consumer设置
         * messageModel CLUSTERING 消息模型,支持以下两种1.集群消费2.广播消费
         * consumeFromWhere CONSUME_FROM_LAST_OFFSET Consumer启动后,默认从什么位置开始消费
         * allocateMessageQueueStrategy
         * allocateMessageQueueAveragely Rebalance 算法实现策略
         * Subsription{} 订阅关系
         * messageListener 消息监听器
         * offsetStore 消费进度存储
         * consumeThreadMin 10 消费线程池数量
         * consumeThreadMax 20 消费线程池数量
         * pullThresholdForQueue 1000 拉去消息本地队列缓存消息最大数
         * pullInterval 拉消息间隔,由于是轮训,所以为0,但是如果用了流控,也可以设置大于0的值,单位毫秒
         * consumeMessageBatchMaxSize 1 批量消费,一次消费杜少条消息
         * pullBatchSize 32 批量拉消息,一次最多拉多少条
         *
         */

        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */

        consumer.setNamesrvAddr("10.112.3.201:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        consumer.subscribe("TopicQuickStart", "TagA");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
                //System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
                MessageExt msg = msgs.get(0);
                try {
                    String topic = msg.getTopic();
                    String msgBody = new String(msg.getBody(),"utf-8");
                    String tags = msg.getTags();
                    System.out.println("get massage : " + " topic : " + topic + " tags : " + tags + " msg : " +msgBody);
                }catch (Exception e){
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER; //requeue 一会再消费
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; // response broker ack
            }
        });

        consumer.start();

        System.out.println("Consumer Started.");
    }
}
