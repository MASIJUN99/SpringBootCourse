package com.sample2.boot;

import com.sample2.boot.bean.Pet;
import com.sample2.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 取出两个同样的组件
        Pet tom = run.getBean("tom", Pet.class);
        Pet tom1 = run.getBean("tom", Pet.class);

        System.out.println("获得的组件不是单实例" + (tom == tom1));
    }

}
