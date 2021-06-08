package com.sample.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 组件通过配置文件中的内容绑定属性
 */
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private int price;

    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}

