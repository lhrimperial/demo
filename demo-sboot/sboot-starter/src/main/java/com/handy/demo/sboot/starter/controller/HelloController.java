package com.handy.demo.sboot.starter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author longhairen
 * @create 2017/8/16 0016 上午 9:39
 */
@Controller
public class HelloController {
    //从application中读取配置，如取不到默认值为hello jack
    @Value("${application.hello:hello jack}")
    private String hello;

    @RequestMapping("/helloJsp")
    public String helloJsp(Map<String, Object> map){
        System.out.println("HelloController.helloJsp().hello="+hello);
        map.put("hello", hello);
        return "helloJsp";
    }
}
