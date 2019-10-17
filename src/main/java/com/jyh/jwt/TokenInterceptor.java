package com.jyh.jwt;

import com.auth0.jwt.interfaces.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/10/17
 * @description：
 */

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //token验证
        if(token != null) {
            Map<String, Claim> claimMap = TokenUtil.verifyToken(token);
            if (claimMap != null) {
                //账户操作。。。
                return true;
            }else {
                //验证错误
                response.sendRedirect(request.getContextPath() + "/jwt/error");
                return false;
            }
        }else {
            //验证错误
            response.sendRedirect(request.getContextPath() + "/jwt/error");
            return false;
        }
    }

}
