package com.simple.demo.dao;

import com.simple.demo.pojo.Department;
import com.simple.demo.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "aa", "12@qq.com", 1, new Department(101,"A部门")));
        employees.put(1002, new Employee(1002, "bb", "123@qq.com", 0, new Department(102,"B部门")));
        employees.put(1003, new Employee(1003, "cc", "1234@qq.com", 1, new Department(103,"C部门")));
        employees.put(1004, new Employee(1004, "dd", "12345@qq.com", 0, new Department(104,"D部门")));
        employees.put(1005, new Employee(1005, "ee", "123456@qq.com", 1, new Department(105,"E部门")));
    }
    private static Integer initId = 1006;

    public void add(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> selectAll() {
        return employees.values();
    }

    public Employee selectById(Integer id) {
        return employees.get(id);
    }

    public void del(Integer id) {
        employees.remove(id);
    }

    public void update(Integer id, Employee employee) {
        del(id);
        employee.setId(id);
        add(employee);
    }

}
