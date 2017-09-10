package com.handy.demo.base.collec;

/**
 * @author longhairen
 * @create 2017-08-27 20:53
 * @description
 **/
public class CallMethod {

    public static Integer value = new Integer(10);

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        System.out.println("调用前x的值："+ value);
        updateValue(value);
        System.out.println("调用后x的值："+ value);

    }

    public static void updateValue(Integer value){
        value = 3 * value;
    }
}
