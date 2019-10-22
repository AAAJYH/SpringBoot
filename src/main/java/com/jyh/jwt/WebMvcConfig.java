package com.jyh.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: jyh
 * @date: 2019/10/21
 * @description：
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    InterceptorConfig interceptorConfig;

    /**
     * 拦截路径
     */
    private String[] pathPatterns = {"/jyh/**"};

    /**
     * 不拦截路径
     */
    private String[] excludePathPatterns = {"/jyh/UserController/login", "/jyh/UserController/msg"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(interceptorConfig)
                    .addPathPatterns(pathPatterns)
                    .excludePathPatterns(excludePathPatterns);
    }

}
