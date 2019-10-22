package com.jyh.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

public class JwtUtil {

    @Autowired
    UserServiceImpl userService;

    private static Logger log = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        Algorithm algorithm =Algorithm.HMAC256(JwtConstant.SECRET);
        Long currentMillis = System.currentTimeMillis();
        String token = JWT.create()
                .withClaim(JwtConstant.TOKEN_OPEN_ID, user.getOpenId())
                .withClaim(JwtConstant.TOKEN_PHONE, user.getPhone())
                .withExpiresAt(new Date(currentMillis + JwtConstant.EXPIRE_MILLIS))
                .sign(algorithm);
        log.info("token: " + token);

        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static Map<String, String> verifyToken(String token) {
        DecodedJWT decodedJWT = null;
        try{
            Map<String, String> result = new HashMap<>(2);
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JwtConstant.SECRET)).build();
            decodedJWT = jwtVerifier.verify(token);
            Map<String, Claim> claimMap = decodedJWT.getClaims();
            claimMap.forEach( (k, v)-> result.put(k, v.asString() ));
            return result;
        }catch (Exception e) {
            log.error("verifyToken is error ...");
            return null;
        }
    }

}
