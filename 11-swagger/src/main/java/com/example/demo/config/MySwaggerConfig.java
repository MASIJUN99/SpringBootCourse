package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 开启Swagger2
public class MySwaggerConfig {

  @Bean
  public Docket docket1() {
    return new Docket(DocumentationType.SWAGGER_2)
       .groupName("A同志写的api");
  }

  @Bean
  public Docket docket2() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("B同志写的api");
  }

  @Bean
  public Docket docket(Environment environment) {
    // 此文档应该只在开发环境出现
    // 添加Environment变量
    // 设置要显示swagger的环境
    Profiles profiles = Profiles.of("dev", "test");
    // 通过environment获取现在的环境是什么
    boolean flag = environment.acceptsProfiles(profiles);

    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .enable(flag)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))  // 指定扫描controller
        .paths(PathSelectors.ant("/masijun/**"))
        .build()  // 工厂模式
        .groupName("组1");
  }

  // 配置Swagger信息 ApiInfo类
  private ApiInfo apiInfo() {

    Contact masijun = new Contact("MASIJUN", "", "masijun99@gmail.com");

    return new ApiInfo(
        "My Swagger Guide",
        "我的SwaggerCodebase",
        "v1.0",
        "http://localhost:8080/index",
        masijun,
         "Apache 2.0",
        "http://www.xxxx.com",
        new ArrayList()
    );
  }
}
