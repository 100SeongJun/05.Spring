package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step02.model.domain.People;

public class Step02_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step02.xml");
//		Car c1 = context.getBean("c1", Car.class);
		People p2 = context.getBean("p1", People.class);
		System.out.println(p2);
		((ConfigurableApplicationContext) context).close();

	}
}
