package com.cimc.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 注册Servlet
 *
 * @author chenz
 */
//@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new RegisterServlet(), "/registerServlet");
    }
}
