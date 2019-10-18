package com.snjly.definition.example;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Date;

public class GenericBeanDefinitionExample {

	public static void main(String[] args) {
		DefaultListableBeanFactory context =
				new DefaultListableBeanFactory();

		GenericBeanDefinition gbd = new GenericBeanDefinition();
		gbd.setBeanClass(MyBean.class);

		MutablePropertyValues mpv = new MutablePropertyValues();
		mpv.add("date", new Date());

		//alternatively we can use:
		// gbd.getPropertyValues().addPropertyValue("date", new Date());
		gbd.setPropertyValues(mpv);

		context.registerBeanDefinition("myBeanName", gbd);

		MyBean bean = context.getBean(MyBean.class);
		bean.doSomething();
	}

	private static class MyBean {
		private Date date;

		public void doSomething() {
			System.out.println("from my bean, date: " + date);
		}

		public void setDate(Date date) {
			this.date = date;
		}
	}
}