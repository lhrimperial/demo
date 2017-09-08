package com.handy.demo.distribute.weba.mapper.slave;

import com.handy.demo.distribute.weba.domain.Address;
import org.springframework.stereotype.Repository;

/**
 * @author longhairen
 * @create 2017/9/8 0008 下午 5:46
 */
@Repository
public interface AddressMapper {

    int save(Address address);

    int update(Address address);

    int delete(int userId);

    Address findByUserId(int userId);
}
