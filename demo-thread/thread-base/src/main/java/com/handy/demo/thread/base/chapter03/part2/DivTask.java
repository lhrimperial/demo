package com.handy.demo.thread.base.chapter03.part2;

import com.mysql.jdbc.TimeUtil;
import scala.tools.nsc.Global;
import sun.java2d.Disposer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author longhairen
 * @create 2017/9/29 0029 下午 3:52
 */
public class DivTask implements Runnable {
    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }

    public static void main(String[] args){
        ExecutorService es = new TrackThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            //es.submit(new DivTask(100, i)); //没有任何提示
            es.execute(new DivTask(100, i));
        }
        es.shutdown();
    }

    /*public static void main(String[] args){
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; i++) {
            //es.submit(new DivTask(100, i)); //没有任何提示
            es.execute(new DivTask(100, i));
        }
        es.shutdown();
    }*/
}
