package com.jyh.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jyh
 * @date 2019/12/2
 * @description
 */

@Service
public class TransactionInterfaceImpl implements TransactionInterface {

    @Autowired
    TransactionDao transactionDao;

    @Override
    public int insert() {
        TransactionPojo pojo = new TransactionPojo(18, "横七");
        int count = transactionDao.insert(pojo);
        return count;
    }

}
