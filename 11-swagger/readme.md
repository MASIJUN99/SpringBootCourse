# Swagger集成

由于Swagger3和2差别挺大，这里按照教程的2来做

## 步骤

1. 新建SpringBopot-web项目
2. 导入相关依赖

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

注意这个依赖并不是Spring官方的

3. 编写HelloWorld

4. 配置Swagger

```java
@Configuration
@EnableSwagger2 // 开启Swagger2
public class MySwaggerConfig {
  
}
```

## Swagger配置扫描接口

```java
return new Docket(DocumentationType.SWAGGER_2)
    .apiInfo(apiInfo())
    .enable(flag)
    .select()
    /* RequestHandlerSelectors 配置扫描内容
    any() 所有
    none() 不扫
    withMethodAnnotation(final Class<? extends Annotation> annotation)  扫描此注解的方法
    withClassAnnotation(final Class<? extends Annotation> annotation)   扫描此注解的类
    annotationPresent(final Class<? extends Annotation> annotation)
    handlerPackage(final String basePackage)
    basePackage(final String basePackage)  基于哪个包扫描
    declaringClass(RequestHandler input)
     */
    .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))  // 指定扫描controller
    /* PathSelectors过滤器
    any()  所有不过滤
    none()  所有过滤
    regex(final String pathRegex)  正则表达式匹配不过滤的内容
    ant(final String antPattern)  正则表达式匹配过滤的内容
     */
    .paths(PathSelectors.ant("/masijun/**"))
    .build()  // 工厂模式
    ;
```

## API分组

创建多个Docket。

## Api注释

添加注解来增加注释

### @ApiModel

给实体类注释

### @ApiModelProperty

给实体类属性注释


# 注意要记得在生产环境关闭Swagger
