package com.handy.demo.distribute.webc.dubbo.consumer.service.confirm;

import com.handy.demo.distribute.webc.dubbo.api.exception.ServiceException;
import com.handy.demo.distribute.webc.dubbo.consumer.service.ITransferService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferServiceConfirm")
public class TransferServiceConfirm implements ITransferService {
	@SuppressWarnings("restriction")
	@javax.annotation.Resource(name = "jdbcTemplate2")
	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = ServiceException.class)
	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException {
		int value = this.jdbcTemplate.update(
				"update tb_account_two set amount = amount + ?, frozen = frozen - ? where acct_id = ?", amount, amount,
				targetAcctId);
		if (value != 1) {
			throw new ServiceException("ERROR!");
		}
		System.out.printf("done increase: acct= %s, amount= %7.2f%n", targetAcctId, amount);
	}

}
