package com.handy.demo.dubbo.provider.controller;

import com.handy.demo.dubbo.api.domain.User;
import com.handy.demo.dubbo.api.service.IUserService;
import com.handy.demo.dubbo.schema.domain.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author longhairen
 * @create 2017/8/11 0011 上午 9:16
 */

@Controller
@RequestMapping("/usre")
public class UserController {

    @Autowired
    private IUserService userService;

    private People people;

    @ResponseBody
    @RequestMapping("/find")
    public User findUser(){
        return userService.findUser("");
    }

    @ResponseBody
    @RequestMapping("/p")
    public People findPeople(){
        return people;
    }

    public People getPeople() {
        return people;
    }

    @Resource
    public void setPeople(People people) {
        this.people = people;
    }
}
