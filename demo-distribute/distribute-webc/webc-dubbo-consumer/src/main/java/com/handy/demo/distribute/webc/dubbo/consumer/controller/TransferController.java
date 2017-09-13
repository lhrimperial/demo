package com.handy.demo.distribute.webc.dubbo.consumer.controller;

import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;
import com.handy.demo.distribute.webc.dubbo.consumer.service.ITransferService;
import com.handy.demo.distribute.webc.dubbo.consumer.service.impl.GenericTransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author longhairen
 * @create 2017/9/13 0013 下午 7:44
 */
@Controller
@RequestMapping("/test")
public class TransferController {

    @Autowired
    private ITransferService genericTransferService;

    @RequestMapping("/tranfer")
    public @ResponseBody String transfer(){
        try {
            genericTransferService.transfer("1001","2001", 50);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "fail";
        }
        return "successfully";
    }
}
