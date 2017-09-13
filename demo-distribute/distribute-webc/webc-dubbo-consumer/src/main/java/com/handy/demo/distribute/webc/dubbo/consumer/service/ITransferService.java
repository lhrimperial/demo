package com.handy.demo.distribute.webc.dubbo.consumer.service;


import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;

public interface ITransferService {

	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException;

}
