package com.handy.demo.dubbo.spi.service.impl;

import com.handy.demo.dubbo.spi.service.HelloService;

/**
 * @author longhairen
 * @create 2017/9/11 0011 下午 4:04
 */
public class DefaultHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name + " DefaultHelloService";
    }
}
