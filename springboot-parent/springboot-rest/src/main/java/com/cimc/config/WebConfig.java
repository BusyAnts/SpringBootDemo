package com.cimc.config;

import com.cimc.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author chenz
 */
//@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //需要拦截的路径
        String[] addPathPatterns = {
                "/user/**"
        };

        //不需要拦截的路径
        String[] excludePathPatterns = {
                "/user/login"
        };
        //注册登录拦截器，还可以注册其他拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
