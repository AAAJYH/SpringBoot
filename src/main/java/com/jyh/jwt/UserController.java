package com.jyh.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

@RestController
@RequestMapping("/jyh/UserController")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/login")
    public String login(User user) {
        return userService.addData(user);
    }

    @RequestMapping("/getCoupon")
    public String getCoupon() {
        return "领取优惠券操作";
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        return "获取用户信息";
    }

    @RequestMapping("/msg")
    public String msg() {
        return "请登录";
    }

}
