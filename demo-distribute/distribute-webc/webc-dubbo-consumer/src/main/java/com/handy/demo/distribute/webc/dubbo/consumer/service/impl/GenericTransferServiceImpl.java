package com.handy.demo.distribute.webc.dubbo.consumer.service.impl;

import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;
import com.handy.demo.distribute.webc.dubbo.api.service.IAccountService;
import com.handy.demo.distribute.webc.dubbo.consumer.service.ITransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("genericTransferService")
@Compensable(interfaceClass = ITransferService.class, confirmableKey = "transferServiceConfirm", cancellableKey = "transferServiceCancel")
public class GenericTransferServiceImpl implements ITransferService {

	@SuppressWarnings("restriction")
	@javax.annotation.Resource(name = "jdbcTemplate2")
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("restriction")
	@javax.annotation.Resource(name = "remoteAccountService")
	private IAccountService remoteAccountService;

	@Transactional(rollbackFor = ServiceException.class)
	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException {

		this.remoteAccountService.decreaseAmount(sourceAcctId, amount);
		this.increaseAmount(targetAcctId, amount);

		// throw new ServiceException("rollback");
	}

	private void increaseAmount(String acctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update("update tb_account_two set frozen = frozen + ? where acct_id = ?", amount, acctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}
