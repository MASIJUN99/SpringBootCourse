package com.sample4.boot.config;

import com.sample4.boot.bean.Pet;
import com.sample4.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean(name = "mimi")
@ConditionalOnMissingBean(name = "mimi")
public class MyConfig {

    @Bean
    public User user01() {
        User user = new User();
        user.setName("李四");
        user.setPet(mimi());
        return user;
    }

    @Bean
    public Pet mimi() {
        return new Pet("猫", "小宝");
    }
}
