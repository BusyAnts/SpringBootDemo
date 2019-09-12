package com.cimc.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author chenz
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    /**
     * 容器加载的时候调用
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 请求被拦截的时候进行调用
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("进入自定义Filter中---过滤前");
        chain.doFilter(request, response);
        System.out.println("进入自定义Filter中---过滤后");
    }

    /**
     * 容器被销毁的时候被调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
