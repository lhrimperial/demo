package com.handy.demo.distribute.weba.service;

import com.handy.demo.distribute.weba.domain.UserInfo;

/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 6:04
 */
public interface IdistributeService {

    boolean save(UserInfo userInfo);

    boolean update(UserInfo userInfo);

    boolean delete(int userId);
}
