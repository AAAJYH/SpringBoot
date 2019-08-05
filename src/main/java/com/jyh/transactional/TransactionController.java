package com.jyh.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jyh
 * @date: 2019/8/4
 * @description：
 */

@RestController
public class TransactionController {

    @Autowired
    TransactionTemplate transactionTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionDao transactionDao;

    @PostMapping("add")
    public int add() {

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

        //隔离级别
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        //传播行为
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(definition);

        TransactionPojo pojo = new TransactionPojo(18, "横七");
        int count = transactionDao.insert(pojo);

        int i = 1/0;

        //回滚
        transactionManager.commit(status);

        return count;
    }

}
