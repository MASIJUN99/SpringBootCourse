package com.example.conig;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

  // ShiroFilterFactoryBean
  @Bean
  public ShiroFilterFactoryBean getFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
    ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
    // 设置安全管理器
    bean.setSecurityManager(defaultWebSecurityManager);

    // 添加shiro内置的过滤器
    /*
      anno: 无需认证就可以访问
      authc: 必须认证了才能访问
      user: 必须拥有 记住我 功能才能用
      perms: 拥有对某个资源的权限才能访问
      role: 拥有某个角色权限才能访问
     */
    Map<String, String> filterMap = new LinkedHashMap<>();

    filterMap.put("/user/add", "perms[user:add]"); // 需要某权限才能访问add
    filterMap.put("/user/*", "authc");  // 通配符
//    filterMap.put("/user/add", "authc");  // 必须登录，实际上是对请求进行拦截
//    filterMap.put("/user/update", "authc");  // 必须登录

    bean.setLoginUrl("/toLogin"); // 如果没登录，就去这里
    bean.setUnauthorizedUrl("/noauth");

    bean.setFilterChainDefinitionMap(filterMap);

    return bean;
  }

  // DefaultWebSecurityManager
  @Bean
  public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    // 关联realm
    securityManager.setRealm(userRealm);
    return securityManager;
  }

  // 创建Realm对象，需要自定义类
  @Bean
  public UserRealm userRealm() {
    return new UserRealm();
  }

}
