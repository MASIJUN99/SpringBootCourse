package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="Hello控制类")
@RestController
public class HelloWorld {

  @GetMapping("/hello")
  public String hello() {
    return "HelloWorld";
  }

  @PostMapping("/user")
  public User user() {
    return new User();
  }

  @ApiOperation("你好用户")
  @GetMapping("/hello/{name}")
  public String helloUser(@PathVariable("name") @ApiParam("用户名") String name) {
    return "hello" + name;
  }

}
