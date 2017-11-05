package com.handy.demo.rocketmq.service.impl;

import com.handy.demo.rocketmq.domain.UserInfo;
import com.handy.demo.rocketmq.mapper.UserInfoMapper;
import com.handy.demo.rocketmq.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Service("userInfoService")
@Scope("prototype")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserInfo(int id) {
        return userInfoMapper.findUserInfo(id);
    }

    @Override
    public List<UserInfo> findUserList() {
        return userInfoMapper.findUserList();
    }

}
