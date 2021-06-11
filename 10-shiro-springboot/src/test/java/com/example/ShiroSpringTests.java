package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		System.out.println(userService.selectByName("root"));
		System.out.println(userService.selectByName("admin"));
		System.out.println(userService.selectByName("masijun"));
		System.out.println(userService.selectByName("123"));
	}

}
