package com.handy.demo.distribute.weba.service;



import com.handy.demo.distribute.weba.domain.UserInfo;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
public interface IUserInfoService {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();

    void saveUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    public void saveBatchUserInfo(List<UserInfo> userInfos);

    public void deleteUserInfo(int id);
}
