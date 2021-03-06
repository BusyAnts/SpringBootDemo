package com.cimc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author chenz
 * @create 2019-09-09 11:22
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.cimc")
public class RestApplication extends SpringBootServletInitializer implements ServletContextInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //servletContext.addServlet("registerServlet", new RegisterServlet()).addMapping("/registerServlet");
        //servletContext.addFilter("myFilter", new MyFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
