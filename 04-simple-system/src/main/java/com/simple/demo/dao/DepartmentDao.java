package com.simple.demo.dao;

import com.simple.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "A部门"));
        departments.put(102, new Department(102, "B部门"));
        departments.put(103, new Department(103, "C部门"));
        departments.put(104, new Department(104, "D部门"));
        departments.put(105, new Department(105, "E部门"));
    }

    public Collection<Department> selectAll() {
        return departments.values();
    }

    public Department selectById(Integer id) {
        return departments.get(id);
    }
}
