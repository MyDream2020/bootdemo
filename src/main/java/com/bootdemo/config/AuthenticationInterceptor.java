package com.bootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @Author: ASUS
 * @Date: 2020/4/9 23:31
 * @Version: 1.0
 */

public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始进入请求地址拦截--"  + "--" + request.getRequestURL());
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            try {
                response.sendRedirect("/bootdemo/error/authenticationError.html");
            }catch (IOException e){
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}
