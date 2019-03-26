package com.snjly.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Package: com.snjly.spring.aop
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 20/03/2019.
 */
@Component
@Aspect
public class MyAspectBean {

	@Pointcut("execution(* com.snjly.spring.aop.*.*(..)))")
	public void pointCut(){

	}

	@Before("execution(* com.snjly.spring.aop.*.*(..)))")
	public String before(){
		System.out.println("before aspect");
		return "before";
	}

	@After("execution(* com.snjly.spring.aop.*.*(..)))")
	public String after(){
		System.out.println("after aspect");
		return "after";
	}

}
