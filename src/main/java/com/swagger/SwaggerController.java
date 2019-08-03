package com.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 姬雨航
 * @date: 2019/7/24 15:43
 * @description：
 *
 * @Api：用于类
 * value：接口
 * tags：说明标签
 */

@Api(tags = "swagger测试controller")
@RestController
@RequestMapping("/SwaggerController/")
public class SwaggerController {

    @ApiOperation(value = "addStudent", notes = "添加方法")
    @PostMapping(value = "addStudent")
    public String addStudent(@RequestBody Student student) {
        return "name："+student.getName()+" age："+student.getAge();
    }

}
