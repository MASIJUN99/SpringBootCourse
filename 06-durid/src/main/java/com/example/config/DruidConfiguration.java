package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfiguration {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        // 设置初始化参数 加入管理员账号
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");  // 这个key是固定的
        map.put("loginPassword", "admin");
        // ip过滤
        map.put("allow", "localhost");

        bean.setInitParameters(map);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        // 加入
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("exclusions", "*,js, *.css, /druid/**");  // 不拦截这些

        bean.setInitParameters(map);


        return bean;
    }

}
