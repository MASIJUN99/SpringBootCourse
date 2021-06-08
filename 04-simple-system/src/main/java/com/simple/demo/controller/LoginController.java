package com.simple.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        // 查询数据库 然后判断
        System.out.println("用户" + username + "登录");
        System.out.println("密码为" + password );

        if (username != null && password.equals("123456")) {
            System.out.println("登陆成功");

            session.setAttribute("loginUser", username);

            return "redirect:/main";
        } else {
            // 登陆失败，告诉用户，用model传值
            System.out.println("登陆失败");
            model.addAttribute("msg", "login.wrong");
            return "login";
        }
    }
}
