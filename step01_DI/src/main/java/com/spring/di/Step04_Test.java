package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.di.config.Step04Config;

import step04.model.domain.People;

public class Step04_Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Step04Config.class);
		System.out.println(context.getBeanDefinitionCount());
//		Car c1 = context.getBean("c1", Car.class);
		People p3 = context.getBean("people", People.class);
		System.out.println(p3);
		((ConfigurableApplicationContext) context).close();

	}
}
