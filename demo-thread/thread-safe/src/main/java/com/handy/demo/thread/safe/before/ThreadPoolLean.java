package com.handy.demo.thread.safe.before;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author longhairen
 * @create 2017/8/24 0024 下午 7:59
 */
public class ThreadPoolLean {
    public static void main(String[] args) throws Exception {
//        testNewFixedThreadPool();
//        testThreadPoolExecutor();
//        testBlockingDequeAndAtomic();
//        testSameRunnable();
//        testCountDownLatch();
//        testCallableAndFuture1();
//        testCompletionService();
        testSemaphore();
    }

    /**
     * Semaphore信号量 拿到信号量的线程可以进入代码，否则就等待。
     * 通过acquire()和release()获取和释放访问许可。下面的例子只允许5个线程同时进入执行acquire()和release()之间的代码
     * @throws Exception
     */
    public static void testSemaphore() throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore sema = new Semaphore(5);

        for (int i = 0; i < 20; i++){
            final int NO = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sema.acquire();
                        System.out.println(Thread.currentThread().getName() + " Accessing " + NO);
                        Thread.sleep((long) (Math.random()*50000));
                        sema.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(runnable);
        }
        exec.shutdown();
    }

    /**
     * 它会首先取完成任务的线程
     * @throws Exception
     */
    public static void testCompletionService() throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<String> serv =
                new ExecutorCompletionService<String>(exec);
        for (int index = 0; index < 5; index++) {
            final int NO = index;
            Callable<String> downImg = new Callable<String>() {
                public String call() throws Exception {
                    Thread.sleep((long) (Math.random() * 10000));
                    return "Downloaded Image " + NO;
                }
            };
            serv.submit(downImg);
        }
        Thread.sleep(1000 * 2);
        System.out.println("Show web content");
        for (int index = 0; index < 5; index++) {
            Future<String> task = serv.take();
            String img = task.get();
            System.out.println(img);
        }
        System.out.println("End");
        // 关闭线程池
        exec.shutdown();
    }

    /**
     * 使用Callable和Future实现线程等待和多线程返回值
     * @throws Exception
     */
    public static void testCallableAndFuture1() throws Exception {
        System.out.println("start main thread");
        int threadCount = 5;
        final ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> tasks = new ArrayList<>(threadCount);
        for (int i = 0; i < threadCount; i++){
            Callable<Integer> call = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    return 1;
                }
            };
            tasks.add(exec.submit(call));
        }
        long total = 0;
        for (Future<Integer> future : tasks) {
            total += future.get();
        }
        exec.shutdown();
        System.out.println("total: " + total);
        System.out.println("end main thread");
    }

    public static void testCallableAndFuture() throws Exception {
        System.out.println("start main thread");
        final ExecutorService exec = Executors.newFixedThreadPool(5);
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start new thread " + Thread.currentThread().getName());
                Thread.sleep((long) (Math.random()*1000));
                System.out.println("end new thread " + Thread.currentThread().getName());
                return "Some Value";
            }
        };
       for (int i = 0; i < 10; i++){
           Future<String> task = exec.submit(call);
           //Thread.sleep(1000*2);
           // 阻塞，并待子线程结束，
           System.out.println(task.get().toString());
       }
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("end main thread");
    }

    public static void testCountDownLatch() throws Exception{
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);

        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++){
            final int NO = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(runnable);
        }
        System.out.println("Game Start!");
        begin.countDown();
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }

    public static void testSameRunnable() throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(5);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            service.execute(runnable);
        }
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        service.shutdown();
        System.out.println("runnable complete!");
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
                            Thread.sleep(1000);
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
