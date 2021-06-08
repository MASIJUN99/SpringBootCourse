# SpringBoot入门

# 1.1 Spring与SpringBoot

# 1.2 SpringBoot2入门

# 1.3 了解自动配置原理

## 1. SpringBoot特点

### 1.1 依赖管理

#### 1.1.1 父项目依赖管理
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.3</version>
</parent>
```

通过maven导入父项目，父项目的依赖可以自动进入子项目。

当我们需要引入新的依赖，我们就可以不用关心版本号，直接加入。

父项目的主要功能就是依赖管理，声明了开发中常用的依赖。

父项目中有一个[父项目](C:\Users\Administrator\.m2\repository\org\springframework\boot\spring-boot-dependencies\2.4.3\spring-boot-dependencies-2.4.3.pom)
，在里面约束了很多依赖的版本，若我们要自己加新的版本，我们在当前项目的pom中重写配置。

例如在父项目中mysql的版本是`<mysql.version>8.0.23</mysql.version>`

在maven网站上查找到了想要的版本号后，
我们在项目的pom文件中添加如下内容，就可以更改版本。

```xml
<properties>
    <mysql.version>5.1.43</mysql.version>
</properties>
```

#### 1.1.2 开发starter场景启动器

当我们在pom引入一个starter之后，我们就引入了场景中的所有依赖。

命名的规则是`spring-boot-starter-*`

在官方文档列举了所有的starter

也可以自己创建一个starter，自己创建的一般以`*-spring-boot-starter`命名

所有的场景启动器都会用到spring-boot-starter依赖，这是核心

[官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter)


> 可以在pom中查看下依赖关系，里面的关系很复杂

#### 1.1.3 版本仲裁

在父项目中继承依赖的版本叫做仲裁的版本，我们想改变这个就可以在pom文件加入那个字段


### 1.2 自动配置

#### 1.2.1 自动配置Tomcat

1. 引入Tomcat依赖
2. 配置Tomcat

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
  <version>2.4.3</version>
  <scope>compile</scope>
</dependency>
```

#### 1.2.2 自动配置SpringMVC

1. 引入了SpringMVC开发的全套组件
2. 配好了SpringMVC的常用功能

#### 1.2.3 自动配置好web常见功能

SpringBoot帮我们配置好了web开发常见的组件

#### 1.2.4 配置的默认包结构

包扫描之类的，都会配置好

主程序所在的包及其所在的下面所有子包都会被默认扫描进来

若我们要扩展扫描包的请求

1. 我们在主程序的@SpringBootApplication，添加scanBasePackage=path属性

2. 我们添加@EnableAutoConfiguration和@ComponentScan(path)

[官方文档](https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-using-the-default-package)

#### 1.2.5 拥有诸多默认值

在`application.properties`可以修改默认值

最终都是映射到某个类。

这个类会在容器中创建对象

#### 1.2.6 按需加载所用的类

有非常多的starter，我们引入了哪个场景才会启用那个场景

全部基于web里的这个依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-autoconfigure</artifactId>
  <version>2.4.3</version>
  <scope>compile</scope>
</dependency>
```

## 2. 容器功能

### 2.1 组建添加

#### 2.1.1 @Configuration

告诉SpringBoot这是一个配置类

通过添加proxyBeanMethods属性来控制是否创建单实例对象，有full和lite模式

#### 2.1.2 @Bean

告诉SpringBoot配置类中的方法，这是一个创建组件的方法。

通过添加"xxx"属性来控制创建组件的名称

#### 2.1.3 @Component

自动创建组件，一般创建普通类和工具类，可添加name属性为组件命名。

#### 2.1.4 @Service

创建Service对象，与Component用法一样。

#### 2.1.5 @Repository

创建Dao对象，同上。

#### 2.1.6 @Controller

告诉SpringBoot这个类是控制器类，就像SpringMVC中那样

#### 2.1.7 @Import

在配置类上加，里面内容是枚举类，可以直接添加某些类到容器中。

#### 2.1.8 @Conditional

条件注入，根据条件进行组件装配。

### 2.2 原生配置文件引入

在Spring中我们会使用.xml文件进行一些bean配置，
但在SpringBoot中要使用注解才能实现这个功能。

#### 2.2.1 @ImportResource

在内部添加Spring配置文件的路径，多用于老项目的迁移。

### 2.3 配置绑定

我们习惯于把常变的放在配置文件，所以我们需要添加.properties文件到SpringBoot

#### 2.3.1 @ConfigurationProperties

我们添加这个注解，自动读取application.properties中前缀prefix与输入的一致的属性。



# 1.4 开始使用SpringBoot

## 1.4.1 一个简单的SpringBoot web应用

详见[04-simple-system](.\04-simple-system)

## 1.4.2 整合jdbc

## 1.4.3 使用Druid连接池

## 1.4.4 整合mybatis

# 2.1 安全

web开发中，安全是第一位的，比如过滤器、拦截器。

安全是刚需，这个时候就出现了安全的框架，比如SpringSecurity、shiro

这两个框架很相似，除了类名不同而已。

解决认证、授权等问题

## 2.1.1 原理

实际上是通过AOP的思想，来分组。

## 2.1.2 使用SpringSecurity

1. 导入security依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. 添加Security配置

3. 自定义配置

在自定义配置的时候，有很多细节可以说，比如链式编程的规范，一开始我还觉得一大串很烦，
后来我发现原来里面大有文章，有很多东西可以配，并且很好配，可以去看看代码。

## 2.1.3 使用Shiro





