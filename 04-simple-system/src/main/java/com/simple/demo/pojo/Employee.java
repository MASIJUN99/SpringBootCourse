package com.simple.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer sex; // 0-female 1-male
    private Department dept;
    private Date birth;

    public Employee(Integer id, String name, String email, Integer sex, Department dept) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.dept = dept;
        this.birth = new Date();
    }

}
