package com.cimc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模拟登陆拦截器
 *
 * @author chenz
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 调用Controller某个方法之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("模拟登录拦截器");
        System.out.println("preHandle");
        //为true才继续往下执行
        return true;
    }

    /**
     * Controller之后调用，视图渲染之前，如果控制器Controller出现了异常，则不会执行此方法
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        System.out.println("postHandle");
    }

    /**
     * 不管有没有异常，这个afterCompletion都会被调用，用于资源清理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion");
    }
}
