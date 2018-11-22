package com.lv.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by simperLv
 * on 2018/10/09 11:12
 *
 * @Description //TODO
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws IOException {
        //System.out.println(request.getRequestURI());
        //登录不拦截
        if (request.getRequestURI().equals("/hello/toLogin") || request.getRequestURI().equals("/user/login")){
            return true;
        }
        Object obj = request.getSession().getAttribute("sessionUser");
        if (obj == null){
            response.sendRedirect("/hello/toLogin");
            return false;
        }
        return true;
    }

}
