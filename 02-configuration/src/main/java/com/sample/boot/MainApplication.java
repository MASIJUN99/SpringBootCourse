package com.sample.boot;

import com.sample.boot.bean.Pet;
import com.sample.boot.bean.User;
import com.sample.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 打印所有组件来看看
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 取出两个同样的组件
        Pet tom = run.getBean("tom", Pet.class);
        Pet tom1 = run.getBean("tom", Pet.class);

        System.out.println("获得的组件是单实例" + (tom == tom1));

        // 配置类也是一个组件
        MyConfig bean = run.getBean(MyConfig.class);

        System.out.println(bean);
    }

}
