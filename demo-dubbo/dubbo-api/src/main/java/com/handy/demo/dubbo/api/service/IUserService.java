package com.handy.demo.dubbo.api.service;

import com.handy.demo.dubbo.api.domain.User;

/**
 * @author longhairen
 * @create 2017/8/11 0011 上午 9:09
 */
public interface IUserService {
    User findUser(String userName);
}
