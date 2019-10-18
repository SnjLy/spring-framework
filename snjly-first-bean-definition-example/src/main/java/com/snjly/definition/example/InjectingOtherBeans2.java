package com.snjly.definition.example;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class InjectingOtherBeans2 {

	public static void main(String[] args) {
		DefaultListableBeanFactory context =
				new DefaultListableBeanFactory();

		//define and register MyOtherBean
		GenericBeanDefinition beanOtherDef = new GenericBeanDefinition();
		beanOtherDef.setBeanClass(MyOtherBean.class);
		context.registerBeanDefinition("other", beanOtherDef);

		//define and register myBean
		GenericBeanDefinition beanDef = new GenericBeanDefinition();
		beanDef.setBeanClass(MyBean.class);
		beanDef.getPropertyValues().
				addPropertyValue("otherBean", context.getBean("other"));

		context.registerBeanDefinition("myBean", beanDef);

		//using MyBean instance
		MyBean bean = context.getBean(MyBean.class);
		bean.doSomething();
	}

	private static class MyBean {
		private MyOtherBean otherBean;

		public void setOtherBean(MyOtherBean otherBean) {
			this.otherBean = otherBean;
		}

		public void doSomething() {
			otherBean.doSomething();
		}
	}

	private static class MyOtherBean {

		public void doSomething() {
			System.out.println("from other bean ");
		}
	}
}