package com.jyh.jwt;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：模拟数据库
 */

@Component
public class UserServiceImpl {

    public static Map<String, String> dataMap = new HashMap<>();

    /**
     * 开发数据
     */
    static {
        dataMap.put("13461020531", "abcdefghijkl13461020531");
    }

    public String addData(User user) {
        dataMap.put(user.getPhone(), user.getOpenId());
        return JwtUtil.getToken(user);
    }

    public String getData(User user) {
        if (user != null) {
            return dataMap.get(user.getPhone());
        }else {
            return null;
        }
    }

}
