package com.sample4.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(MainApplication.class, args);

        boolean user01 = ac.containsBean("user01");
        System.out.println(user01);
        boolean mimi = ac.containsBean("mimi");
        System.out.println(mimi);
    }
}
