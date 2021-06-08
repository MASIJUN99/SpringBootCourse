package com.simple.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 这个方法return true就放行，否则不放行
        Object loginUser = request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            // 没有登陆
            request.setAttribute("msg", "login.needLogin");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        } else {
            return true;
        }

    }

}

