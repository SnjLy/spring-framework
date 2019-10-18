package com.snjly.definition.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanDefinitionRegistryPostProcessorExample {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MyConfig.class);

		MyBean bean = (MyBean) context.getBean("myBeanName");
		bean.doSomething();
	}

	@Configuration
	public static class MyConfig {
		@Bean
		MyConfigBean myConfigBean() {
			return new MyConfigBean();
		}
	}

	private static class MyConfigBean
			implements BeanDefinitionRegistryPostProcessor {

		@Override
		public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
				throws BeansException {

			GenericBeanDefinition bd = new GenericBeanDefinition();
			bd.setBeanClass(MyBean.class);
			bd.getPropertyValues().add("strProp", "my string property");
			registry.registerBeanDefinition("myBeanName", bd);
		}

		@Override
		public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
				throws BeansException {
			//no op
		}
	}

	private static class MyBean {
		private String strProp;

		public void setStrProp(String strProp) {
			this.strProp = strProp;
		}

		public void doSomething() {
			System.out.println("from MyBean:  " + strProp);
		}
	}
}