package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserMapper userMapper;

  @GetMapping("/all")
  public List<User> all() {
    return userMapper.selectAll();
  }


}
