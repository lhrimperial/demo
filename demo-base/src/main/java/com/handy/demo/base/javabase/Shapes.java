package com.handy.demo.base.javabase;

import java.lang.reflect.*;

/**
 * @author longhairen
 * @create 2017/8/28 0028 下午 7:16
 */
public class Shapes {

    public static void main(String[] args){
        Class clazz = Shapes.class;
        Shapes shapes = new Shapes();
        Class clazz1 = shapes.getClass();
        Array array = null;
        Constructor constructor = null;
        Field field = null;
        Method method = null;
        Modifier modifier = null;
        Proxy proxy = null;
    }
}
