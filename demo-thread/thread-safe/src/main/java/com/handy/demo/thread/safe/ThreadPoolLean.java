package com.handy.demo.thread.safe;

import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author longhairen
 * @create 2017/8/24 0024 下午 7:59
 */
public class ThreadPoolLean {
    public static void main(String[] args) throws Exception{
//        testNewFixedThreadPool();
//        testThreadPoolExecutor();
        testBlockingDequeAndAtomic();
    }

    public static long randomTime(){
        return (long) (Math.random() * 1000);
    }

    public static void testBlockingDequeAndAtomic() throws Exception {
        final BlockingDeque<File> queue = new LinkedBlockingDeque<>(100);
        ExecutorService service = Executors.newFixedThreadPool(5);

        final File rootFile = new File("C:\\Users\\Administrator\\Desktop\\nio\\root");
        final File exitFile = new File("");

        final AtomicInteger rc = new AtomicInteger();
        final AtomicInteger wc = new AtomicInteger();

        // 读线程
        Runnable read = new Runnable() {
            public void run() {
                scanFile(rootFile);
                scanFile(exitFile);
            }

            public void scanFile(File file) {
                if (file.isDirectory()) {
                    File[] files = file.listFiles(/*new FileFilter() {
                        public boolean accept(File pathname) {
                            return pathname.isDirectory();// || pathname.getPath().endsWith(".log");
                        }
                    }*/);
                    for (File one : files) {
                        scanFile(one);
                    }
                } else {
                    try {
                        int index = rc.incrementAndGet();
                        System.out.println("Read0: " + index + " " + Thread.currentThread().getName() + " " + file.getPath());
                        queue.put(file);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        service.submit(read);
        // 四个写线程
        for (int index = 0; index < 4; index++) {
            // write thread
            final int num = index;
            Runnable write = new Runnable() {
                String threadName = "Write" + num;

                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(randomTime());
                            int index = wc.incrementAndGet();
                            File file = queue.take();
                            // 队列已经无对象
                            if (file == exitFile) {
                                // 再次添加"标志"，以让其他线程正常退出
                                queue.put(exitFile);
                                break;
                            }
                            System.out.println(threadName + ": " + index + " " + file.getPath());
                        } catch (InterruptedException e) {
                        }
                    }
                }
            };
            service.submit(write);
        }
        service.shutdown();
    }

    public static void testThreadPoolExecutor() throws Exception {
        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.DAYS, blockingDeque);
        for (int i = 0; i < 20; i++){
            final int index = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " sleep");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(String.format(Thread.currentThread().getName() + " thread %d finished", index));
                }
            });
        }
        executor.shutdown();
    }

    public static void testNewFixedThreadPool() throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run task");
                }
            };
            service.execute(runnable);
        }
        //用于关闭启动线程，如果不调用该语句，jvm不会关闭。
        service.shutdown();
        //用于等待子线程结束，再继续执行下面的代码
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("all thread complete");

    }
}
