package com.cimc.config;

import com.cimc.interceptor.LoginInterceptor;
import com.cimc.interceptor.SecondInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义拦截器配置
 *
 * @author chenz
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**")
                .excludePathPatterns("/user/login");
        //拦截所有请求
        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/*/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}