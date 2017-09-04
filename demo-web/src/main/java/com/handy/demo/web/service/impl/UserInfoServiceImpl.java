package com.handy.demo.web.service.impl;

import com.handy.demo.web.domain.UserInfo;
import com.handy.demo.web.mapper.UserInfoMapper;
import com.handy.demo.web.service.IUserInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
