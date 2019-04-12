//package com.aaa.shiro;
//
//import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.realm.Realm;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 配置shiro拦截器
// */
//@Configuration
//public class ShiroFilter {
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
//        //1.创建ShiroFilterFactoryBean对象
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//        //2.设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager());
//        //3.设置需要登录认证的url，认证失败跳转的url
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //4.设置成功跳转的路径
//        shiroFilterFactoryBean.setSuccessUrl("/MainView");
//
//        Map<String,String> shiroFilterChain=new HashMap<String,String>(20);
//
//        //5.设置不需要认证就能访问的路径
//        shiroFilterChain.put("/loginIndex","anon");
//        shiroFilterChain.put("/favicon.ico","anon");
//
//        //6.设置必须认证的路径
//        shiroFilterChain.put("/login","authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(shiroFilterChain);
//
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 配置自定义realm对象
//     * @return
//     */
//    @Bean
//    public Realm customRealm(){
//        return new CustomRealm();
//    }
//
//    /**
//     * 配置SecurityManager对象，并设置realm
//     * @return
//     */
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
//        defaultWebSecurityManager.setRealm(customRealm());
//        return defaultWebSecurityManager;
//    }
//
//    /**
//     * 配置shiro标签对thymeleaf模板的支持
//     * @return
//     */
//    @Bean
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }
//
//    /**
//     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
//     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
//     * @return
//     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        advisorAutoProxyCreator.setProxyTargetClass(true);
//        return advisorAutoProxyCreator;
//    }
//
//    /**
//     * 开启shiro aop注解支持
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//}
