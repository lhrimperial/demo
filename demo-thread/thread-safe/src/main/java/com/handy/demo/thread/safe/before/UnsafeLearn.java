package com.handy.demo.thread.safe.before;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author longhairen
 * @create 2017-08-26 15:32
 * @description
 **/
public class UnsafeLearn {
    private static int byteArrayBaseOffset;

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        Field f = null;
        Unsafe unsafe = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        /**
         * 在堆外分配一个byte
         */
        long allocatedAddress = unsafe.allocateMemory(1L);
        unsafe.putByte(allocatedAddress, (byte) 100);
        byte shortValue = unsafe.getByte(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(shortValue));
/**
 * 重新分配一个long
 */
        allocatedAddress = unsafe.reallocateMemory(allocatedAddress, 8L);
        unsafe.putLong(allocatedAddress, 1024L);
        long longValue = unsafe.getLong(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(longValue));
/**
 * Free掉,这个数据可能脏掉
 */
        unsafe.freeMemory(allocatedAddress);
        longValue = unsafe.getLong(allocatedAddress);
        System.out.println(new StringBuilder().append("Address:").append(allocatedAddress).append(" Value:").append(longValue));
    }

    public static void test(String[] args) throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);

        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 5);
        System.out.println(Arrays.toString(data));



    }
}
