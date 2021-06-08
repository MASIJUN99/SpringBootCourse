# 01-HelloWorld

## 1. 创建maven项目，空的即可不需要骨架

## 2. 添加父工程

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.3</version>
</parent>
```

## 3. 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

## 4. 主程序

基本上固定的
```java
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
```

## 5. 控制器

直接返回内容给浏览器而不是一个链接。

```java
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello World!";
    }
}
```

添加注释有两种方法

1. 两个经典的注解
```java
@ResponseBody  // 告诉类直接返回内容给浏览器
@Controller  // 告诉java这是个控制器类
```
2. SpringBoot的注解
```java
@RestController
```

## 6. 测试
直接运行main方法

## 7. 简化配置

所有配置写在
[application.properties](src/main/resources/application.properties)
文件中

多参考
[SpringBoot官方手册](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)
官方手册


## 8. 简化部署

只需要引入一个插件
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
将项目打成jar包

步骤：
1. 右侧maven选择lifecycle
2. 选择clean和package运行
3. 得到jar包
4. 进入cmd输入java -jar xxx.jar运行


注意：
1. 取消快速编辑模式
2. 一定要导入所有依赖，非常多
3. SpringBoot真方便...
