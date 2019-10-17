package com.jyh.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author: jyh
 * @date: 2019/10/17
 * @description：
 */

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/login")
    public HashMap<String, String> login(Member member, HttpServletRequest request, HttpServletResponse response) {
        Member user = memberService.getUser(member.getNickName());
        HashMap<String, String> tokenMap = new HashMap<>(1);
        //用户存且密码正确在则颁发token
        if (null != user && member.getPassword().equals(user.getPassword())) {
            response.setHeader("token", TokenUtil.sign(user.getId().toString()));
            tokenMap.put("token", TokenUtil.sign(user.getId().toString()));
            //存入redis中设置过期时间1天
            System.out.println("存入redis设置过期天数");
             return tokenMap;
        }else {
            tokenMap.put("token", "不存在此用户");
        }
        return tokenMap;
    }

    @RequestMapping("/a")
    public String a() {
        return "a";
    }

    @RequestMapping("/b")
    public String b() {
        return "b";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

}
