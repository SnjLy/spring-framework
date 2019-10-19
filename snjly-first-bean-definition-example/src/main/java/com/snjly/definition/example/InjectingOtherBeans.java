package com.snjly.definition.example;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class InjectingOtherBeans {

	public static void main(String[] args) {
		DefaultListableBeanFactory context = new DefaultListableBeanFactory();

		//define and register MyOtherBean
		GenericBeanDefinition beanOtherDef = new GenericBeanDefinition();
		beanOtherDef.setBeanClass(MyOtherBean.class);
		context.registerBeanDefinition("other", beanOtherDef);

		//definine and register myBean
		GenericBeanDefinition beanDef = new GenericBeanDefinition();
		beanDef.setBeanClass(MyBean.class);
		MutablePropertyValues mpv = new MutablePropertyValues();
		mpv.addPropertyValue("otherBean", context.getBean("other"));
		beanDef.setPropertyValues(mpv);
		context.registerBeanDefinition("myBean", beanDef);

		//using MyBean instance
		MyBean bean = context.getBean(MyBean.class);
		bean.doSomething();
	}

	private static class MyBean {
		public MyBean() {
			System.out.println("MyBean construct...");
		}
		private MyOtherBean otherBean;

		public void setOtherBean(MyOtherBean otherBean) {
			this.otherBean = otherBean;
		}

		public void doSomething() {
			otherBean.doSomething();
		}
	}

	private static class MyOtherBean {
		public MyOtherBean() {
			System.out.println("MyOtherBean construct...");
		}
		public void doSomething() {
			System.out.println("from other bean ");
		}
	}
}