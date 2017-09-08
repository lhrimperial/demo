package com.handy.demo.distribute.weba.mapper.master;

import com.handy.demo.distribute.weba.domain.UserInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by longhairen on 2017/4/20 0020.
 */
@Repository
public interface UserInfoMapper {

    UserInfo findUserInfo(int id);

    List<UserInfo> findUserList();

    int saveUserInfo(UserInfo userInfo);

    int updateUserInfo(UserInfo userInfo);

    int saveBatchUserInfo(List<UserInfo> userInfos);

    int deleteUserInfo(int id);

}
