package com.handy.demo.web.service;


import com.handy.demo.web.domain.UserInfo;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
public interface IUserInfoService {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();
}
