package com.snjly.spring.demo;

import com.snjly.spring.demo.config.AppConfig;
import com.snjly.spring.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : LiuYong at 2019-10-18
 * @package: com.snjly.spring.demo
 */
public class App {

	public static void main(String[] args) {
		//初始化spring容器
		//方式一、
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//方式二、自己register
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();


		//获取bean
		UserService bean = context.getBean(UserService.class);
		//执行service bean方法
		System.out.println(bean.getUser(10));
		context.close();
	}
}
