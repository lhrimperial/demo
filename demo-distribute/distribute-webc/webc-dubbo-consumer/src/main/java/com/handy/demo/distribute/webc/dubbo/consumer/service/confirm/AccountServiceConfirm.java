package com.handy.demo.distribute.webc.dubbo.consumer.service.confirm;

import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;
import com.handy.demo.distribute.webc.dubbo.api.service.IAccountService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceConfirm")
public class AccountServiceConfirm implements IAccountService {

	@SuppressWarnings("restriction")
	@javax.annotation.Resource(name = "jdbcTemplate1")
	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = ServiceException.class)
	public void increaseAmount(String acctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update(
				"update tb_account_one set amount = amount + ?, frozen = frozen - ? where acct_id = ?", amount, amount, acctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("done increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void decreaseAmount(String acctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update("update tb_account_one set frozen = frozen - ? where acct_id = ?", amount, acctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("done decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
