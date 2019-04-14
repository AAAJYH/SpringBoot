package com.shiro.service;

import com.shiro.dao.AdminDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jyh
 * @date 2019/4/10
 */

@Service
public class AdminService {

    @Resource
    AdminDao adminDao;

    /**
     * 查询账号是否存在
     * @param account
     * @return
     */


}
