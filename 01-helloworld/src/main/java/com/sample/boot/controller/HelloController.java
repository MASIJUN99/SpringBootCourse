package com.sample.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 添加@ResponseBody表面这些返回字符串直接给浏览器
 * 使用@RestController来代替Controller和ResponseBody两个注解
 */

//@ResponseBody
//@Controller

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello World!" + "你好";
    }
}
