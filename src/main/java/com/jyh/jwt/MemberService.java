package com.jyh.jwt;

import org.springframework.stereotype.Service;

/**
 * @author: jyh
 * @date: 2019/10/17
 * @description：
 */

@Service
public class MemberService {

    Member getUser(String name) {
        Member m = new Member();
        if ("jyh".equals(name)) {
            m.setId(1);
            m.setNickName("jyh");
            m.setAvatar("a.jpg");
            m.setPassword("123");
        }
        return m;
    }

}
