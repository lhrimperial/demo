package com.handy.demo.sboot.starter.service.impl;

import com.handy.demo.sboot.starter.domain.UserInfo;
import com.handy.demo.sboot.starter.mapper.UserInfoMapper;
import com.handy.demo.sboot.starter.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/22 0022 下午 3:57
 */
@Service("userInfoDruidService")
public class UserInfoDruidService implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserInfo(int id) {
        return userInfoMapper.findUserInfo(id);
    }

    @Override
    public List<UserInfo> findUserInfoList() {
        return userInfoMapper.findUserList();
    }
}
