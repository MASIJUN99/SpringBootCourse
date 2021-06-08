package com.sample3.boot;

import com.sample3.boot.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ac = SpringApplication.run(MainApplication.class, args);

        System.out.println("是否创建对象");
        String[] beanNamesForType = ac.getBeanNamesForType(Date.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        String[] beanNamesForType1 = ac.getBeanNamesForType(StringBuilder.class);
        for (String s : beanNamesForType1) {
            System.out.println(s);
        }
    }

}
