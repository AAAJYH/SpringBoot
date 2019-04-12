package com.shiro.dao;

import com.shiro.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@Mapper
public interface AdminDao {

    /**
     * 查询此账号是否存在
     * @param account
     * @return
     */
    @Select("select * from Admin where account=#{account}")
    public Admin byAccountQuery(@Param("account") String account);

}
