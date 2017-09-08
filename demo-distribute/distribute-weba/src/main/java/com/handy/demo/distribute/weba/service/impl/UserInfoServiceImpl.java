package com.handy.demo.distribute.weba.service.impl;

import com.handy.demo.distribute.weba.domain.UserInfo;
import com.handy.demo.distribute.weba.mapper.master.UserInfoMapper;
import com.handy.demo.distribute.weba.service.IUserInfoService;
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

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoMapper.saveUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public void saveBatchUserInfo(List<UserInfo> userInfos) {
        userInfoMapper.saveBatchUserInfo(userInfos);
    }

    @Override
    public void deleteUserInfo(int id) {
        userInfoMapper.deleteUserInfo(id);
    }


}
