package com.handy.demo.distribute.weba.service.impl;

import com.handy.demo.distribute.weba.domain.UserInfo;
import com.handy.demo.distribute.weba.mapper.master.UserInfoMapper;
import com.handy.demo.distribute.weba.mapper.slave.AddressMapper;
import com.handy.demo.distribute.weba.service.IdistributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 6:06
 */
@Service
public class DistributeService implements IdistributeService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    @Transactional
    public boolean save(UserInfo userInfo) {
        boolean isSave = false;
        if (userInfoMapper.saveUserInfo(userInfo) != 1) {
            throw new RuntimeException("保存用户失败！");
        }
        userInfo.getAddress().setUserId(userInfo.getId());
        if (addressMapper.save(userInfo.getAddress()) != 1) {
            throw new RuntimeException("保存用户地址失败！");
        }
        isSave = true;

        return isSave;
    }

    @Override
    public boolean update(UserInfo userInfo) {
        boolean isUpdate = false;
        if (userInfoMapper.updateUserInfo(userInfo) != 1) {
            throw new RuntimeException("修改用户失败！");
        }
        if (addressMapper.update(userInfo.getAddress()) != 1) {
            throw new RuntimeException("修改用户地址失败！");
        }
        isUpdate = true;
        return isUpdate;
    }

    @Override
    public boolean delete(int userId) {
        boolean isDelete = false;
        if (userInfoMapper.deleteUserInfo(userId) != 1) {
            throw new RuntimeException("删除用户失败！");
        }
        if (addressMapper.delete(userId) != 1) {
            throw new RuntimeException("删除用户地址失败！");
        }
        isDelete = true;
        return isDelete;
    }
}
