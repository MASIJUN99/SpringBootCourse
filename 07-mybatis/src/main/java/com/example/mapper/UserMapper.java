package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper // 或在SpringBootApplication里添加MapperScan
@Repository
public interface UserMapper {

    List<User> selectAll();

    User selectById();

    int addUser();

    int updateById();

    int deleteUser();

}
