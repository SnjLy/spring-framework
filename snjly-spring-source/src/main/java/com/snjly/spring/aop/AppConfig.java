package com.snjly.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Package: com.snjly.spring.aop
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 20/03/2019.
 */

@Configuration
@ComponentScan("com.snjly")
@EnableAspectJAutoProxy
public class AppConfig {


}
