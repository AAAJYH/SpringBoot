package com.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * \* Author: 姬雨航
 * \* Date: 2019/7/24 15:43
 * \* Description：
 * \
 */

@Data
@ApiModel("学生对象")
public class Student {

    @ApiModelProperty(value = "姓名", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(value = "年龄", dataType = "Integer", required = true)
    private Integer age;

}
