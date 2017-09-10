package com.handy.demo.base.io;

import java.nio.ByteBuffer;

/**
 * @author longhairen
 * @create 2017-08-19 12:22
 * @description
 **/
public class JavaNio {

    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        ByteBuffer.allocateDirect(1024);
    }
}
