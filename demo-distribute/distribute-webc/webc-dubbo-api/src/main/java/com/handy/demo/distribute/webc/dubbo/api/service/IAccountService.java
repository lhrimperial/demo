package com.handy.demo.distribute.webc.dubbo.api.service;

import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;

/**
 * @author longhairen
 * @create 2017/9/13 0013 下午 4:15
 */
public interface IAccountService {
    void increaseAmount(String accountId, double amount) throws ServiceException;

    void decreaseAmount(String accountId, double amount) throws ServiceException;
}
