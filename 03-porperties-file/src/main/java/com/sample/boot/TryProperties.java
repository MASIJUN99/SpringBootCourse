package com.sample.boot;

import com.sample.boot.bean.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TryProperties {
    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(TryProperties.class, args);

        Car car1 = ac.getBean("car", Car.class);
        // 通过配置文件创建成功
        System.out.println(car1);
    }
}
