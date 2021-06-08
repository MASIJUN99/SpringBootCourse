package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> selectAll() {
    return userMapper.selectAll();
  }

  @Override
  public User selectByName(String username) {
    return userMapper.selectByName(username);
  }
}
