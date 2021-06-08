package com.simple.demo.config;

import com.simple.demo.utils.StringToDateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 自定义的国际化组件生效，因为自定义国际化组件并不是一个配置类
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    // 自定义视图解析器。
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/", "/login", "/user/login",
                        "/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**");
    }
}
