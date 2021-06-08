package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/all")
    public List<Map<String, Object>> all() {
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/add")
    public String addUser() {
        String sql = "INSERT INTO user(name, password) VALUES('user5', 'psw5')";
        jdbcTemplate.execute(sql);
        return "updata ok";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "UPDATE user SET name=?, password=? WHERE id=" + id;
        Object[] info = new Object[2];
        info[0] = "小m";
        info[1] = "111111";
        jdbcTemplate.update(sql, info);
        return "update ok";
    }

    @RequestMapping("/del/{id}")
    public String addUser(@PathVariable("id") int id) {
        String sql = "DELETE FROM user WHERE id=" + id;
        jdbcTemplate.execute(sql);
        return "del ok";
    }
}
