package com.handy.demo.thread.base.chapter03.part2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author longhairen
 * @create 2017/9/29 0029 下午 3:59
 */
public class TrackThreadPoolExecutor extends ThreadPoolExecutor {

    public TrackThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrack(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrack(), Thread.currentThread().getName()));
    }

    private Exception clientTrack() {
        return new Exception("Client stack track");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, final String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }
}
