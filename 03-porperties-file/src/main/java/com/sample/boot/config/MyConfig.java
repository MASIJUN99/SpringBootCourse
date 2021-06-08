package com.sample.boot.config;


import com.sample.boot.bean.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({Car.class})
public class MyConfig {
}
