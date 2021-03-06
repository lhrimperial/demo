package com.handy.demo.thread.dislock.lock.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashSet;
import java.util.Set;

/**
 * @author longhairen
 * @create 2017/8/14 0014 下午 2:23
 */
public class IDGeneratorTest {
    private static Set<String> generatedIds = new HashSet<String>();

    private static final String LOCK_KEY = "lock.lock";
    private static final long LOCK_EXPIRE = 5 * 1000;

    @Test
    public void testV1_0() throws Exception {

        SocketAddress addr = new InetSocketAddress("localhost", 9999);

        Jedis jedis1 = new Jedis("localhost", 6379);
        Lock lock1 = new RedisBasedDistributedLock(jedis1, LOCK_KEY, LOCK_EXPIRE, addr);
        IDGenerator g1 = new IDGenerator(lock1);
        IDConsumeTask consume1 = new IDConsumeTask(g1, "consume1");

        Jedis jedis2 = new Jedis("localhost", 6379);
        Lock lock2 = new RedisBasedDistributedLock(jedis2, LOCK_KEY, LOCK_EXPIRE, addr);
        IDGenerator g2 = new IDGenerator(lock2);
        IDConsumeTask consume2 = new IDConsumeTask(g2, "consume2");

        Thread t1 = new Thread(consume1);
        Thread t2 = new Thread(consume2);
        t1.start();
        t2.start();

        Thread.sleep(20 * 1000); //让两个线程跑20秒

        IDConsumeTask.stopAll();

        t1.join();
        t2.join();
    }

    static String time() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    static class IDConsumeTask implements Runnable {

        private IDGenerator idGenerator;

        private String name;

        private static volatile boolean stop;

        public IDConsumeTask(IDGenerator idGenerator, String name) {
            this.idGenerator = idGenerator;
            this.name = name;
        }

        public static void stopAll() {
            stop = true;
        }

        public void run() {
            System.out.println(time() + ": consume " + name + " start ");
            while (!stop) {
                String id = idGenerator.getAndIncrement();
                if (id != null) {
                    if(generatedIds.contains(id)) {
                        System.out.println(time() + ": duplicate id generated, id = " + id);
                        stop = true;
                        continue;
                    }

                    generatedIds.add(id);
                    System.out.println(time() + ": consume " + name + " add id = " + id);
                }
            }
            // 释放资源
            idGenerator.release();
            System.out.println(time() + ": consume " + name + " done ");
        }

    }

}
