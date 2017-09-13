package com.handy.demo.distribute.webc.dubbo.provider.service.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;
import com.handy.demo.distribute.webc.dubbo.api.service.IAccountService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Compensable(interfaceClass = IAccountService.class, confirmableKey = "accountServiceConfirm", cancellableKey = "accountServiceCancel")
public class AccountServiceImpl implements IAccountService {

	@SuppressWarnings("restriction")
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = ServiceException.class)
	public void increaseAmount(String acctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update("update tb_account_one set frozen = frozen + ? where acct_id = ?", amount, acctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void decreaseAmount(String acctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update(
				"update tb_account_one set amount = amount - ?, frozen = frozen + ? where acct_id = ?", amount, amount, acctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", acctId, amount);
		// throw new ServiceException("rollback");
	}

}
