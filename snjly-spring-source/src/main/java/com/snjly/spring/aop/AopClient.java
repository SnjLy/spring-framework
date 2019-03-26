package com.snjly.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Package: com.snjly.spring.aop
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 21/03/2019.
 */
public class AopClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MyAopBean myAopBean = (MyAopBean) context.getBean("myAopBean");
		myAopBean.query();
	}
}
