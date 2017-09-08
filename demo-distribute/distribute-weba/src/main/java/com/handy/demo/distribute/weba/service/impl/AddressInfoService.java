package com.handy.demo.distribute.weba.service.impl;

import com.handy.demo.distribute.weba.domain.Address;
import com.handy.demo.distribute.weba.mapper.slave.AddressMapper;
import com.handy.demo.distribute.weba.service.IAddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 6:01
 */
@Service
public class AddressInfoService implements IAddressInfoService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void save(Address address) {
        addressMapper.save(address);
    }

    @Override
    public void update(Address address) {
        addressMapper.update(address);
    }

    @Override
    public void delete(int userId) {
        addressMapper.delete(userId);
    }

    @Override
    public void findByUserId(int userId) {
        addressMapper.findByUserId(userId);
    }
}
