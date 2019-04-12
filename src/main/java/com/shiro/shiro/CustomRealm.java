package com.shiro.shiro;

import com.shiro.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Realm
 */
public class CustomRealm extends AuthorizingRealm{

    @Resource
    AdminService adminService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();

        //角色
        List<String> roleList=new ArrayList<String>();
        roleList.add("role1");
        roleList.add("role2");

        //权限
        List<String> permissionList=new ArrayList<String>();
        permissionList.add("permission1");
        permissionList.add("permission2");

        //添加角色集合
        simpleAuthorizationInfo.addRoles(roleList);
        //添加字符串权限集合
        simpleAuthorizationInfo.addStringPermissions(permissionList);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       /* //1.获取token中的账户
        String principal=authenticationToken.getPrincipal().toString();
        Admin admin=adminService.byAccountQuery(principal);
        //2.账号不存在，抛出UnknowAccountException（未知账号异常），否则返回认证信息并验证token凭证（密码）
        if(admin==null){
            throw new UnknownAccountException();
        }else{
            return new SimpleAuthenticationInfo(admin.getAccount(),admin.getPassword(),getName());
        }*/
        return new SimpleAuthenticationInfo();
    }
}
