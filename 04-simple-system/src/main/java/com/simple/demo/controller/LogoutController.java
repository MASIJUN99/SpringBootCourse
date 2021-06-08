package com.simple.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        // 退出登录需要清除session
        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        return "redirect:/";
    }
}
