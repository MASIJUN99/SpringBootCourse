package com.sample5.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(MainApplication.class, args);

        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        boolean user01 = ac.containsBean("userTest");
        System.out.println(user01);
    }
}
