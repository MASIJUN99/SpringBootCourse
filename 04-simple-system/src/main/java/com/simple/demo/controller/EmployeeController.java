package com.simple.demo.controller;

import com.simple.demo.dao.DepartmentDao;
import com.simple.demo.dao.EmployeeDao;
import com.simple.demo.pojo.Department;
import com.simple.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String employeeList(Model model) {
        Collection<Employee> employees = employeeDao.selectAll();
        model.addAttribute("emps", employees);
        return "emps/tables";
    }

    @GetMapping("/emps/add")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.selectAll();
        model.addAttribute("depts", departments);
        return "emps/add";
    }


    @PostMapping("/emps/add")
    public String employeeAdd(Employee employee) {
        employee.setDept(departmentDao.selectById(employee.getDept().getId()));
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emps/updateEmp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.selectById(id);
        Collection<Department> departments = departmentDao.selectAll();
        model.addAttribute("id", id);
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emps/edit";
    }

    @PostMapping("/emps/updateEmp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Employee employee) {
        employee.setDept(departmentDao.selectById(employee.getDept().getId()));
        employeeDao.update((Integer) id, employee);
        return "redirect:/emps";
    }

    @RequestMapping("/emps/del/{id}")
    public String delEmp(@PathVariable("id") Integer id) {
        employeeDao.del(id);
        return "redirect:/emps";
    }

}
