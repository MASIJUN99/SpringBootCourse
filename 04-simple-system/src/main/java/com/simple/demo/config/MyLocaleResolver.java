package com.simple.demo.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String lang = request.getParameter("lang");

        Locale locale = null;
        if (lang != null) {

            // 此处为携带了国际化参数
            String[] s = lang.split("_");
            locale = new Locale(s[0], s[1]);

            // 将第一次设置的语言放在session，下次没设置就可以取出来
            HttpSession session = request.getSession();
            session.setAttribute("lang", locale);

        } else {
            // 未携带国家化参数，找一下session
            HttpSession session = request.getSession();
            Locale sessionLang = (Locale) session.getAttribute("lang");

            if (sessionLang != null) {
                // Session携带了国际化参数
                locale = sessionLang;
            } else {
                // Session没有国际化参数，设为默认值
                //locale = Locale.getDefault();
                locale = new Locale("zh", "CN");
            }
        }

        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
