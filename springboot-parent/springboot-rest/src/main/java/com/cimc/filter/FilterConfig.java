package com.cimc.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 注册Filter
 *
 * @author chenz
 */
//@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean myFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean(new MyFilter());
		registration.addUrlPatterns("/*");
		return registration;
	}
}
