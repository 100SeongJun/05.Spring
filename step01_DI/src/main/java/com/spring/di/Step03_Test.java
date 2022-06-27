package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.model.domain.Car;
import step03.model.domain.People;

public class Step03_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");
		Car c1 = context.getBean("c1", Car.class);
		People p3 = context.getBean("people", People.class);
		System.out.println(p3);
	}
}
