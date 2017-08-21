package com.handy.demo.sboot.starter.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.handy.demo.sboot.starter.domain.UserInfo;
import com.handy.demo.sboot.starter.service.IUserInfoJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:29
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoJdbcService userInfoJdbcService;

    @RequestMapping("/find/{id}")
    public UserInfo findUserInfo(@PathVariable("id") int id){
        return userInfoJdbcService.findUserInfo(id);
    }

    @RequestMapping("/list")
    public List<UserInfo> findUserList(){
        return userInfoJdbcService.findUserInfoList();
    }
}
