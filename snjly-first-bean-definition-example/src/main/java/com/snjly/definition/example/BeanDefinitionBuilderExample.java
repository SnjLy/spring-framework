package com.snjly.definition.example;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionBuilderExample {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinitionBuilder b = BeanDefinitionBuilder.rootBeanDefinition(MyBean.class).addPropertyValue("str", "myStringValue");

		beanFactory.registerBeanDefinition("myBean", b.getBeanDefinition());

		MyBean bean = beanFactory.getBean(MyBean.class);
		bean.doSomething();
	}

	private static class MyBean {
		private String str;

		public MyBean() {
			System.out.println("MyBean construct...");
		}

		public void setStr(String str) {
			this.str = str;
		}

		public void doSomething() {
			System.out.println("from MyBean " + str);
		}
	}
}