package com.handy.demo.sboot.starter.service;

import com.handy.demo.sboot.starter.domain.UserInfo;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 上午 10:19
 */
public interface IUserInfoJdbcService {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserInfoList();
}
