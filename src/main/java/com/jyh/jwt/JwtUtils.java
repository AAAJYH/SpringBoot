package com.jyh.jwt;

import com.mysql.jdbc.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author: jyh
 * @date: 2019/10/16
 * @description：
 */

public class JwtUtils {

    public static final String SUBJECT = "guli";

    //秘钥
    public static final String APPSECRET = "guli";

    //过期时间
    public static final long EXPIRE = 1000 * 60 * 30;

    /**
     * 生成jwt token
     * @param member
     * @return
     */
    public static String geneJsonWebToken(Member member) {
        if (member == null || member.getId() == null || member.getNickName() == null || member.getAvatar() == null) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", member.getId())
                .claim("nickName", member.getNickName())
                .claim("avatar", member.getAvatar())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET)
                .compact();

        return token;
    }

    /**
     * 检验jwt token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 测试生成 jwt token
     * @return
     */
    public static String testGeneJwt() {
        Member member = new Member();
        member.setId(999);
        member.setAvatar("www.guli.com");
        member.setNickName("Helen");

        String token = JwtUtils.geneJsonWebToken(member);
        System.out.println("test token " + token);
        return token;
    }

    /**
     * 测试校验 jwt token
     * @param token
     */
    public static void testCheck(String token) {
        Claims claims = JwtUtils.checkJWT(token);
        String nickName = (String) claims.get("nickName");
        String avatar = (String) claims.get("avatar");
        String id = claims.get("id").toString();
        System.out.println("nickName: " + nickName + " avatar: "+ avatar + " id: " + id);
    }

    public static void main(String[] args) {
        String token = testGeneJwt();
        testCheck(token);
    }

}
