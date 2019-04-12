package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/loginIndex")
    public String loginIndex(){
        return "/shiro/login";
    }

    /**
     * shiro认证失败跳转登陆页面
     * @return
     */
    @RequestMapping("/login")
    public String failure(HttpServletRequest request){
        String exception=(String) request.getAttribute("shiroLoginFailure");
        String msg="";
        if(exception!=null){
            if(UnknownAccountException.class.getName().equals(exception)){
                msg="账号异常";
            }else if(IncorrectCredentialsException.class.getName().equals(exception)){
                msg="密码异常";
            }
        }
        request.getSession().setAttribute("msg",msg);
        return "/shiro/login";
    }

    /**
     * shiro认证成功跳转主页面
     * @return
     */
    @RequestMapping("/MainView")
    public String mainView(){
        return "/shiro/MainView";
    }

    @RequestMapping("/exit")
    public String exit(){
        SecurityUtils.getSubject().logout();
        return "/shiro/login";
    }

    @RequiresGuest
    @RequestMapping("/requiresGuest")
    @ResponseBody
    public String requiresGuest(){
        return "游客访问";
    }

    @RequestMapping("/requiresAuthentication")
    @ResponseBody
    @RequiresAuthentication
    public String requiresAuthentication(){
        return "已认证";
    }

    @RequiresRoles(value={"role1","role2"})
    @RequestMapping("/requiresRoles")
    @ResponseBody
    public String requiresRoles(){
        return "有role1,role2角色";
    }

}
