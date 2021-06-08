package com.example.mapper;

import com.example.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

  public List<User> selectAll();

  public User selectByName(String name);


}
