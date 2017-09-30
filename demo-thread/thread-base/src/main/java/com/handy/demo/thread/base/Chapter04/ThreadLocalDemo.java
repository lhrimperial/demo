package com.handy.demo.thread.base.Chapter04;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author longhairen
 * @create 2017/9/30 0030 上午 9:57
 */
public class ThreadLocalDemo {
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class PareDate implements Runnable {
        int i = 0;

        public PareDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                //Date t = sdf.parse("2015-03-29 19:29:" + i % 60);
                Date t = tl.get().parse("2015-03-29 19:29:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new PareDate(i));
        }
        es.shutdown();
    }
}
