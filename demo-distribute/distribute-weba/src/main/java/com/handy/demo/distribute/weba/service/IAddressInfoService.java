package com.handy.demo.distribute.weba.service;

import com.handy.demo.distribute.weba.domain.Address;

/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 6:01
 */
public interface IAddressInfoService {

    void save(Address address);

    void update(Address address);

    void delete(int userId);

    void findByUserId(int userId);
}
