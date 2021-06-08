package com.example.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  // 链式编程
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 仅首页可以所有人访问
    // 功能页只能有权限的人访问
    http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/1/**").hasRole("vip1")
        .antMatchers("/2/**").hasRole("vip2")
        .antMatchers("/3/**").hasRole("vip3");

    // 没有权限，回跳到登录页。
    // http.formLogin().loginPage("/login");  // 自定义登录页
    http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login")
        .usernameParameter("username").passwordParameter("password")  // 自定义用户数据的变量名
        .successForwardUrl("/");
    // 开启注销
    http.logout().logoutSuccessUrl("/");

    // 关闭跨站攻击CSRF
    http.csrf().disable();

    // 开启记住我功能，在cookies里保存2周
    http.rememberMe().rememberMeParameter("remember");

  }

  // 在SpringBoot老版本可以使用
  // 在新版本需要加入加密方式，搜索PasswordEncoder就可以找到很多加密方式
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // 往数据库添加用户
    // auth.jdbcAuthentication()
    //     .withUser("admin").password("admin").roles("vip1");

    // 往内存中添加用户
    // auth.inMemoryAuthentication()
    //     .withUser("admin").password("admin").roles("vip1", "vip2", "vip3");

    // 往内存中添加用户，并加密
    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("vip1", "vip2", "vip3")
        .and()
        .withUser("vip1").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
        .and()
        .withUser("vip2").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2")
        .and()
        .withUser("vip3").password(new BCryptPasswordEncoder().encode("123456")).roles("vip3");
  }
}
