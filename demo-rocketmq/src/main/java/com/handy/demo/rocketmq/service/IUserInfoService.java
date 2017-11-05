package com.handy.demo.rocketmq.service;



import com.handy.demo.rocketmq.domain.UserInfo;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
public interface IUserInfoService {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();
}
