package com.jyh.transactional;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jyh
 * @date: 2019/8/4
 * @description：
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class TransactionPojo {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 姓名
     */
    private String name;

    public TransactionPojo(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

}
