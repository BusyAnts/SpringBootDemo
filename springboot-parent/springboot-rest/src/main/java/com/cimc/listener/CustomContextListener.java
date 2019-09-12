package com.cimc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义监听器
 *
 * @author chenz
 */
@WebListener
public class CustomContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("======contextInitialized========");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("======contextDestroyed========");
		
	}

}