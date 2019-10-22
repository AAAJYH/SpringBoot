package com.jyh.jwt;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

public class JwtConstant {

    /**
     * 过期时间（毫秒）
     */
    private static final Integer MILLIS = 1000;
    private static final Integer SECOND = 60;
    private static Integer MINUTE = 3;
    public static Integer EXPIRE_MILLIS = MILLIS * SECOND * MINUTE;

    /**
     * 秘钥
     */
    public static final String SECRET = "jyh";


    /**
     * token里边的key
     */
    public static final String TOKEN_OPEN_ID = "open_id";
    public static final String TOKEN_PHONE = "phone";

    /**
     * 绿色通道key
     */

}
