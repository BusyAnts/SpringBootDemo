package com.cimc;

import com.cimc.filter.MyFilter;
import com.cimc.servlet.RegisterServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * @author chenz
 * @create 2019-09-09 11:22
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.cimc.servlet,com.cimc.filter")
public class RestApplication implements ServletContextInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("registerServlet", new RegisterServlet()).addMapping("/registerServlet");
        servletContext.addFilter("myFilter", new MyFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
