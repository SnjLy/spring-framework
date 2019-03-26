package com.snjly.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @Package: com.snjly.spring.ioc
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 21/03/2019.
 */
@Component("myAopBean")
public class MyAopBean {

	public Object query(){
		System.out.println("假装查询数据");
		return new Object();
	}
}
