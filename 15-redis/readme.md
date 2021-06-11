# Redis整合SpringBoot

这是一个简单的Demo，只是简单整合一下，
后续的会单独学一个Redis的笔记。

> 说明：
> 
> 在SpringBoot2.x后，原来的jedis被替换成了
> lettuce
> 
> jedis是直连，多线程操作不安全，就要使用
> jedis pool连接池
> 
> lettuce采用netty，实例可以在多个线程中共享，
> 不存在线程不安全的情况，可以减少线程数据，

## 源码分析

```java
@Bean
@ConditionalOnMissingBean(name = "redisTemplate")  // 我们可以自己写一个类来替换这个类
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    // 默认的没有过多设置，但是redis要序列化
    // 两个泛型都是Object类，我们需要转换成<String, Object>
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}

// 下面这个Bean是因为redis最常用的类型就是String，所以单独提出来了一个类
@Bean
@ConditionalOnMissingBean
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate template = new StringRedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
```



## 步骤

1. 导入依赖

2. 配置连接

   ```yaml
   spring:
     redis:
       host: 127.0.0.1
       port: 6379
       database: 0
   ```

3. 测试代码

   写在Test里

   ```java
   package com.example;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   import org.springframework.data.redis.connection.RedisConnection;
   import org.springframework.data.redis.core.RedisTemplate;
   
   @SpringBootTest
   class RedisSpringApplicationTests {
   
   	@Autowired
   	private RedisTemplate redisTemplate;
   
   	@Test
   	void contextLoads() {
   		// 1. redisTemplate  操作不同的数据类型，api和我们的指令屎一样的
   		// opsForValue  操作字符串，类似String
   		// opsForList   操作列表，类似List
   		// opsForGeo...
   		// ....等等
   		// 通过链式编程来进行操作
   
   		// 2. 除了基本操作，我们常用方法都可以直接通过这个redisTemplate操作
   		// 比如基本的CRUD
   
   		// 获取redis连接对象，一般少用
   		// RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
   		// connection.flushDb();
   		// connection.flushAll();
   
   		// 基本的set和get
   		redisTemplate.opsForValue().set("myKey", "myValue");
   		System.out.println(redisTemplate.opsForValue().get("myKey"));
   
   	}
   
   }
   ```

   





