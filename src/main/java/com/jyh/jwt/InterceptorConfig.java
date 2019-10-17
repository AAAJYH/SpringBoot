package com.jyh.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: jyh
 * @date: 2019/10/17
 * @description：
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration  registration = registry.addInterceptor(tokenInterceptor);
        //拦截配置
        registration.addPathPatterns("/jwt/**");
        //排除配置
        registration.excludePathPatterns("/jwt/login", "/jwt/error");
    }

}
