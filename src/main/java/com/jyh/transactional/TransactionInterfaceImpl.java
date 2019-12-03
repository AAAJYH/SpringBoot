package com.jyh.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jyh
 * @date 2019/12/2
 * @description
 */

@Service
public class TransactionInterfaceImpl implements TransactionInterface {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    TransactionInterface service;

    @Override
    @Transactional
    public int insert() {
        TransactionPojo pojo = new TransactionPojo(18, "横七");
        int count = transactionDao.insert(pojo);

        //在这修改
        this.update();

        return count;
    }

    @Transactional
    public void update() {
        System.out.println("修改操作");
    }

}
