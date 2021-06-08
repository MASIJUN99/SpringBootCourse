package com.example.service;

import com.example.pojo.User;
import java.util.List;

public interface UserService {

  public List<User> selectAll();

  public User selectByName(String username);

}
