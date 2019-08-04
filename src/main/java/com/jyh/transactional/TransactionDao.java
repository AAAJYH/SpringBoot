package com.jyh.transactional;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: jyh
 * @date: 2019/8/4
 * @description：
 */

@Mapper
@Repository
public interface TransactionDao extends BaseMapper<TransactionPojo> {



}
