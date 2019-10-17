package com.jyh.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/10/17
 * @description：
 */

public class TokenUtil {

    /**
     * token 秘钥
     */
    public static final String TOKEN_SECRET = "27f56a1ca0a347618ff39c7fdf9ab684";

    /**
     * expire 超时时间
     */
    private static final long  OUT_TIME = 150 * 60 * 1000;

    private static Logger log = LoggerFactory.getLogger(TokenUtil.class);

    /**
     * 加密
     * @param userId
     * @return
     */
    public static String sign(String userId) {
        try{
            Date expiration_time = new Date(System.currentTimeMillis() + OUT_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> headerMap = new HashMap<>(2);
            headerMap.put("type", "JWT");
            headerMap.put("alg", "HS256");
            return JWT.create().withHeader(headerMap)
                    .withClaim("userId", userId)
                    .withExpiresAt(expiration_time)
                    .sign(algorithm);
        }catch(Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT decodedJWT = null;
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
            decodedJWT = verifier.verify(token);
            log.info("超时时间: " + decodedJWT.getExpiresAt());
            log.info("载体信息: " + decodedJWT.getClaim("userId").asString());
            log.info("算法: " + decodedJWT.getAlgorithm());
        }catch(Exception e) {
            log.error(e.getMessage());
            return null;
        }
        return decodedJWT.getClaims();
    }



}
