package com.handy.demo.distribute.webb.rocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author longhairen
 * @create 2017/9/13 0013 下午 2:51
 */
public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("rocketmq");

        /**
         * producer配置项
         *  producerGroup DEFAULT_PRODUCER (一个线程下只能有一个组,但是一个组下面可以有多个实例,生产者组)
         *  Producer组名,多个producer如果属于一个应用,发送同样的消息,则应该将他们视为同一组
         *  createTopicKey WBW102 在发送消息时,自动创建服务器不存在的topic,需制定key
         *  defaultTopicQueueNums4 发送消息时,自动创建服务器不存在的topic,默认创建的队列数
         *  sendMsgTimeout 10000 发送消息超时时间,单位毫秒
         *  compressMsgBodyOverHowmuch 4096 消息body超过多大开始压缩(Consumer收到消息会自动解压缩),单位:字节
         *  retryTimesWhenSendFailed 重试次数 (可以配置)
         *  retryAnotherBrokerWhenNotStoreOK FALSE 如果发送消息返回sendResult,但是sendStatus!=SEND_OK,是否重发
         *  maxMessageSize 131072 客户端限制消息的大小,超过报错,同时服务端也会限制(默认128k)
         *  transactionCheckListener 事务消息回查监听器,如果发送事务消息,必须设置
         *  checkThreadPoolMinSize 1 Broker回查Producer事务状态时,线程池大小
         *  checkThreadPoolMaxSize 1 Broker回查Producer事务状态时,线程池大小
         *  checkRequestHoldMax 2000 Broker回查Producer事务状态,Producer本地缓冲请求队列大小
         */

        producer.setNamesrvAddr("10.112.3.201:9876");
        producer.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Message msg = new Message("TopicQuickStart",// topic
                        "TagA",// tag
                        "KKK",//key用于标识业务的唯一性
                        ("Hello RocketMQ " + i).getBytes()// body 二进制字节数组
                );
                SendResult sendResult = producer.send(msg); //ACK确认反馈,通过result判断消息发送成功还是失败
                System.out.println(sendResult); //msgID会在msg经过msgQueue逻辑结构之后才会有ID
            }
            catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        producer.shutdown();
    }
}
