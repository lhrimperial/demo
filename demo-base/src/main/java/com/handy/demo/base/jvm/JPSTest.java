package com.handy.demo.base.jvm;

/**
 * @author longhairen
 * @create 2017-09-03 8:01
 * @description
 **/
public class JPSTest {
    public static void main(String[] args) throws  Exception {
/*        System.out.println("thread start");
        Thread.sleep(100000000);
        System.out.println("thread end");*/

        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d) ;
        System.out.println(e==f) ;
        System.out.println(c==(a+b) ) ;
        System.out.println(c.equals(a+b) ) ;
        System.out.println(g==(a+b) ) ;
        System.out.println(g.equals(a+b) ) ;
    }
}
