package com.example.conig;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

  @Autowired
  UserService userService;

  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    System.out.println("执行token授权");

    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    info.addStringPermission("user:add");

    return info;
  }


  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    System.out.println("执行token认证");
    // 获取用户名与密码，数据库

    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    User user = userService.selectByName(token.getUsername());

    if (user == null) {
      // 没有这个人
      return null; // 自动抛出异常
    }
    // 密码认证不需要自己做，怕泄露
    return new SimpleAuthenticationInfo("", user.getPassword(), "");
  }

}
