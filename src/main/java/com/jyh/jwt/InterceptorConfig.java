package com.jyh.jwt;

import com.auth0.jwt.interfaces.Claim;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

@Component
public class InterceptorConfig implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    @Autowired
    UserServiceImpl userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (false) {
            /**
             * 路色通道（省略）
             */
        }

        if (false) {
            /**
             * 开发模式（省略）
             */
        }

        log.info("拦截方法");
        String token = request.getHeader("token");
        if (token != null) {
            Map<String, String> claimMap = JwtUtil.verifyToken(token);
            if (claimMap != null) {
                String phone = claimMap.get(JwtConstant.TOKEN_PHONE);
                String openId = claimMap.get(JwtConstant.TOKEN_OPEN_ID);
                if (openId.equals( getData(phone) )) {
                    /**
                     * 验证成功
                     */
                    return true;
                }else {
                    /**
                     * 验证失败都去登陆页面
                     */
                    response.sendRedirect("/jyh/UserController/msg");
                    return false;
                }
            }else {
                response.sendRedirect("/jyh/UserController/msg");
                return false;
            }
        }else {
            response.sendRedirect("/jyh/UserController/msg");
            return false;
        }
    }

    private String getData(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userService.getData(user);
    }

}
