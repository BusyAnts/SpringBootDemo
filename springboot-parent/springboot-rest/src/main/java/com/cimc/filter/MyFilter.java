package com.cimc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author chenz
 */
//@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("进入自定义Filter中");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
