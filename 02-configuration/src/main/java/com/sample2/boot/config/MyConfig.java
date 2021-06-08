package com.sample2.boot.config;

import com.sample2.boot.bean.Pet;
import com.sample2.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Full模式
 * Lite模式
 *
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {

    /**
     * 给容器中添加组件，以方法名为id
     * 返回的值，就是在容器中的实例
     * 以返回值为类型
     */
    @Bean
    public User user01() {
        return new User("张三", 18);
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
