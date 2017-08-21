package com.handy.demo.web.mapper;

import com.handy.demo.web.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Repository
public interface UserInfoMapper {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();

}
