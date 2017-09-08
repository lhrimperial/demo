package com.handy.demo.distribute.weba.cotroller;

import com.handy.demo.distribute.weba.domain.Address;
import com.handy.demo.distribute.weba.domain.UserInfo;
import com.handy.demo.distribute.weba.service.IUserInfoService;
import com.handy.demo.distribute.weba.service.IdistributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author longhairen
 * @create 2017/8/21 0021 下午 4:28
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IdistributeService distributeService;

    @RequestMapping("/save")
    public boolean saveUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("zhangqing");
        userInfo.setPassWord("12345");
        userInfo.setEmail("zhangqing@123.com");
        userInfo.setMobileNo("12345678909");
        userInfo.setGender("M");
        Address address = new Address();
        address.setAddressName("zhongguohangzhou");
        address.setNotes("wozhendehaoxiangni");
        userInfo.setAddress(address);
        return distributeService.save(userInfo);
    }


    @RequestMapping("/find/{id}")
    public @ResponseBody
    UserInfo findUser(@PathVariable("id") int id){
        return userInfoService.findUserInfo(id);
    }

    @RequestMapping("/list")
    public @ResponseBody
    List<UserInfo> findUserList(){
        return userInfoService.findUserList();
    }
}
