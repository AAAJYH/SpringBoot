package com.jyh.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 姬雨航
 * @date: 2019/7/24 15:43
 * @description：
 */

@Data
@ApiModel("学生对象")
public class Student {

    @ApiModelProperty(value = "姓名", dataType = "String", required = true, notes = "填写姓名")
    private String name;

    @ApiModelProperty(value = "年龄", dataType = "Integer", required = true, notes = "填写年龄")
    private Integer age;

}
