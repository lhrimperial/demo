package com.handy.demo.dubbo.spi;

import com.handy.demo.dubbo.spi.service.HelloService;

import java.util.ServiceLoader;

/**
 * @author longhairen
 * @create 2017/9/11 0011 下午 4:08
 */
public class JdkSpiTest {

    public static void main(String[] args) throws Exception{
        ServiceLoader<HelloService> helloServiceLoader=ServiceLoader.load(HelloService.class);
        for(HelloService item : helloServiceLoader){
            String temp = item.sayHello("andy");
            System.out.println(temp);
        }
    }
}
