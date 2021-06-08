package com.sample.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * 这是一个spring boot应用
 * 添加 @SpringBootApplication 注解
 * 基本上是固定写法
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // 1. 返回一个IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2. 查看所有bean
        String[] names = run.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println(name);
        }


    }
}
