package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling  // 开启定时功能的注解
@SpringBootApplication
public class TiktocSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiktocSpringApplication.class, args);
	}

}
