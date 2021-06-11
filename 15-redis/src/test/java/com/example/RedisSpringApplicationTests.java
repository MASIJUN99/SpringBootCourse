package com.example;

import com.example.pojo.User;
import com.example.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSpringApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	void testSetAndGet() {
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

	@Test
	void testUser() throws JsonProcessingException {
		User user = new User("admin", "123456");
		// 普通操作，直接存User
		redisTemplate.opsForValue().set("user",user);
		// 真实开发，序列化后存json
//		redisTemplate.opsForValue().set("user", new ObjectMapper().writeValueAsString(user));

		System.out.println(redisTemplate.opsForValue().get("user"));
	}

	@Test
	void testUtils() {
		redisUtil.set("name", "masijun");
		System.out.println(redisUtil.get("name"));
	}

}
